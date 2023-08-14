package com.travelapp.configuration.exception;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@Component
public class AuthExceptionHandler implements AuthenticationEntryPoint, AccessDeniedHandler {
    @Autowired
    private MessageSource messageSource;

    private final String exceptionPath = "http://localhost:8080/api/exception/%d";

    private String getMessage(String key) {
        return messageSource.getMessage(key, null,"Lỗi server", LocaleContextHolder.getLocale());
    }

    @Override
    public void commence(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
        String message = getMessage("AuthenticationException.message");
        String detailMessage = e.getLocalizedMessage();
        int code = 9;
        String moreInformation = String.format(exceptionPath, code);
        ErrorResponse errorResponse = new ErrorResponse(message, detailMessage, null, code, moreInformation);

        // convert object to json
        String json = new ObjectMapper()
                .writerWithDefaultPrettyPrinter()
                .writeValueAsString(errorResponse);

        // return json
        httpServletResponse.setContentType("application/json; charset=UTF-8");
        httpServletResponse.getWriter().write(json);
    }

    @Override
    public void handle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AccessDeniedException e) throws IOException, ServletException {
        String message = getMessage("AccessDeniedException.message");
        String detailMessage = e.getLocalizedMessage();
        int code = 10;
        String moreInformation = String.format(exceptionPath, code);
        ErrorResponse errorResponse = new ErrorResponse(message, detailMessage, null, code, moreInformation);

        // convert object to json
        String json = new ObjectMapper()
                .writerWithDefaultPrettyPrinter()
                .writeValueAsString(errorResponse);

        // return json
        httpServletResponse.setContentType("application/json; charset=UTF-8");
        httpServletResponse.getWriter().write(json);
    }

}
