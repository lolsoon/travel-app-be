package com.travelapp.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Tour {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Integer id;

    @Column(name = "tourName", nullable = false)
    private String tourName;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "price", nullable = false)
    private double price;

    @Column(name = "duration", nullable = false)
    private int duration;

    @ManyToOne
    @JoinColumn(name = "location_id", referencedColumnName = "id", nullable = false)
    private Location location;

    @Column(name = "startDate", nullable = false)
    @CreationTimestamp
    private LocalDateTime startDate;

    @Column(name = "endDate", unique = false)
    @CreationTimestamp
    private LocalDateTime endDate;

    public Tour(Integer id, String tourName, String description, double price, int duration, Location location) {
        this.tourName = tourName;
        this.description = description;
        this.price = price;
        this.duration = duration;
        this.location = location;
    }

}
