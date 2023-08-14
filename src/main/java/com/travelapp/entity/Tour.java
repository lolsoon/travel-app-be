package com.travelapp.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "tours")
public class Tour {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tour_id", unique = true, nullable = false)
    private Integer tourId;

    @Column(name = "tour_name", nullable = false)
    private String tourName;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "price", nullable = false)
    private double price;

    @Column(name = "sale_price")
    private double salePrice;

    @Column(name = "duration", nullable = false)
    private int duration;

    @Column(name = "thumbnail_url",nullable = false)
    private String thumbnailUrl;

    @Column(name = "destination", nullable = false)
    private String destination;

    @Column(name = "start_date", nullable = false)
    @CreationTimestamp
    private LocalDateTime startDate;

    @Column(name = "end_date", nullable = false)
    @CreationTimestamp
    private LocalDateTime endDate;

}
