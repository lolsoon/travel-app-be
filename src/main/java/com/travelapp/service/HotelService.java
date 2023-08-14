package com.travelapp.service;

import com.travelapp.dto.HotelDTO;
import com.travelapp.entity.Hotel;
import com.travelapp.repository.IHotelRepository;
import com.travelapp.service.interfaceService.IHotelService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Service

public class HotelService implements IHotelService {
    @Autowired
    private IHotelRepository hotelRepository;

    //    @Override
//    public void createHotel(Hotel hotel) {
//        // Truy xuất thông tin về người dùng hiện tại
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        // Kiểm tra có phải ADMIN
//        if (authentication != null && authentication.getAuthorities().contains(new SimpleGrantedAuthority("ADMIN"))) {
//            hotelRepository.save(hotel);
//        } else {
//            throw new RuntimeException("Not allowed");
//        }
//    }
    @Override
    public void createHotel(HotelDTO hotelDTO) {
        Hotel hotel = new Hotel();
        BeanUtils.copyProperties(hotelDTO, hotel);

        LocalDateTime checkInDate = hotelDTO.toEntity().getCheckInDate();
        LocalDateTime checkOutDate = hotelDTO.toEntity().getCheckOutDate();

        if (checkInDate != null && checkOutDate != null) {
            hotel.setHotelName(hotelDTO.toEntity().getHotelName());
            hotel.setCheckInDate(checkInDate);
            hotel.setCheckOutDate(checkOutDate);
            hotel.setAddress(hotelDTO.toEntity().getAddress());
            hotel.setPricePerNight(hotel.getPricePerNight());

            //  số ngày ở
            long numberOfNights = ChronoUnit.DAYS.between(checkInDate, checkOutDate);

            // Tính tổng giá tiền
            BigDecimal totalPrice = hotel.getPricePerNight().multiply(BigDecimal.valueOf(numberOfNights));
            hotel.setTotalPrice(totalPrice);

            hotelRepository.save(hotel);
        } else {
            throw new RuntimeException("Không thể tạo khách sạn mới");
        }
    }


    @Override
    public List<Hotel> getAllHotels() {
        return hotelRepository.getAllHotels();
    }

    @Override
    public Hotel findHotelById(Integer hotelId) {
        return hotelRepository.findHotelById(hotelId);
    }

    @Override
    public Hotel findHotelByName(String hotelName) {
        return hotelRepository.findHotelByName(hotelName);
    }

    @Override
    public List<Hotel> findHotelByAddress(String address) {
        return hotelRepository.findHotelByAddress(address);
    }

    @Override
    public List<Hotel> searchHotels(String address, LocalDateTime checkInDate, LocalDateTime checkOutDate) {
        return hotelRepository.findByLocationAndCheckInDateLessThanEqualAndCheckOutDateGreaterThanEqual(address,checkOutDate,checkInDate);
    }
    @Override
    public List<Hotel> findByPriceLessThan(BigDecimal pricePerNight) {
        return hotelRepository.findByPriceLessThan(pricePerNight);
    }

    //    @Override
////    public void updateHotel(Hotel hotel) {
////        // Lấy thông tin người dùng hiện tại từ SecurityContextHolder
////        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
////        if (authentication == null || !authentication.isAuthenticated()) {
////            throw new IllegalArgumentException("Người dùng chưa đăng nhập");
////        }
////        //Kiểm tra Admin role hay không
////        boolean isAdmin = authentication.getAuthorities().stream().anyMatch(authority -> authority.getAuthority().equals("ADMIN"));
////        if (!isAdmin) {
////            throw new IllegalArgumentException("Không có quyền update hotel");
////        }
////        // Lưu vào repo
////        hotelRepository.save(hotel);
////    }
    @Override
    public void updateHotel(Integer hotelId, HotelDTO hotelDTO) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || !authentication.isAuthenticated()) {
            throw new IllegalArgumentException("Người dùng chưa đăng nhập");
        }
        Hotel hotel = findHotelById(hotelId);
        if (hotel != null) {
            BeanUtils.copyProperties(hotelDTO, hotel);
        }
        boolean isAdmin = authentication.getAuthorities().stream().anyMatch(authority -> authority.getAuthority().equals("ADMIN"));
        if (!isAdmin) {
            throw new IllegalArgumentException("Không có quyền update hotel");
        }
        hotelRepository.save(hotel);
    }

    @Override
    public void deleteHotel(Integer hotelId) {
        // check exists hotel ?
        Hotel hotel = hotelRepository.findHotelById(hotelId);
        if (hotel == null) {
            throw new IllegalArgumentException("hotel không tồn tại!");
        }
        hotelRepository.delete(hotel);

    }
}
