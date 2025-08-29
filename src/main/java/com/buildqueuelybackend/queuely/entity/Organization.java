package com.buildqueuelybackend.queuely.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Organization {
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String address;
    private double latitude;
    private double longitude;


    @ManyToOne
    @JoinColumn(name = "admin_id", nullable = false)
    private User admin;

    @OneToMany(mappedBy = "organization", cascade = CascadeType.ALL)
    private List<QueueSection> queueSections;


}
