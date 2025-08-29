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

    public Organization() {
    }
    public Organization(Long id, String name, String address, double latitude, double longitude, User admin, List<QueueSection> queueSections) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.latitude = latitude;
        this.longitude = longitude;
        this.admin = admin;
        this.queueSections = queueSections;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public User getAdmin() {
        return admin;
    }

    public void setAdmin(User admin) {
        this.admin = admin;
    }

    public List<QueueSection> getQueueSections() {
        return queueSections;
    }

    public void setQueueSections(List<QueueSection> queueSections) {
        this.queueSections = queueSections;
    }
}
