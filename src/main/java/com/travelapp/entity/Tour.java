package com.travelapp.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

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

    @Column(name = "location", nullable = false)
    private String location;

    @Column(name = "startDate", nullable = false)
    @CreationTimestamp
    private Date startDate;

    @Column(name = "endDate", unique = false)
    @CreationTimestamp
    private Date endDate;

    public Tour(Integer id, String  tourName, String description, double price, int duration, String location) {
        this.tourName = tourName;
        this.description = description;
        this.price = price;
        this.duration = duration;
        this.location = location;
    }

}
