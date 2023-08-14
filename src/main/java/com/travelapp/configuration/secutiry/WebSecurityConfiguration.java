package com.travelapp.configuration.secutiry;

import com.travelapp.configuration.exception.AuthExceptionHandler;
import com.travelapp.service.interfaceService.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.stereotype.Component;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;



import java.util.Arrays;

import static org.springframework.security.config.Customizer.withDefaults;

@Component
@EnableWebSecurity
public class WebSecurityConfiguration {
    @Autowired
    private IUserService userService;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity, AuthExceptionHandler authExceptionHandler) throws Exception {
        return httpSecurity
                .csrf().disable()
                .cors(withDefaults())
                .exceptionHandling(handler -> handler
                        .authenticationEntryPoint(authExceptionHandler)
                        .accessDeniedHandler(authExceptionHandler)
                )
                .authorizeRequests(auth -> auth
                        .antMatchers("/api/users/**").hasAnyAuthority("ADMIN")
                        .antMatchers(HttpMethod.DELETE).hasAnyAuthority("ADMIN")
                        .antMatchers(HttpMethod.PUT, "/api/tours/**", "/api/payments/**", "/api/hotels/**", "/api/flights/**", "/api/bookings/**").hasAnyAuthority("ADMIN")
                        .antMatchers(HttpMethod.POST, "/api/tours/**", "/api/payments/**", "/api/hotels/**", "/api/flights/**", "/api/bookings/**").hasAnyAuthority("ADMIN")
                        .antMatchers("/api/auth/login/**", "/api/auth/register/**").permitAll()
                        .anyRequest().authenticated()
                )
                .httpBasic(withDefaults())
                .build();
    }

    @Bean
    public AuthenticationManager authManager(HttpSecurity httpSecurity, UserDetailsService userDetailsService, PasswordEncoder passwordEncoder) throws Exception {
        return httpSecurity.getSharedObject(AuthenticationManagerBuilder.class)
                .userDetailsService(userDetailsService)
                .passwordEncoder(passwordEncoder)
                .and()
                .build();
    }

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        final CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedMethods(Arrays.asList("HEAD", "GET", "POST", "PUT", "DELETE"));
        configuration.applyPermitDefaultValues();

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }
}
