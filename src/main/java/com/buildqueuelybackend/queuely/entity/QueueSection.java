package com.buildqueuelybackend.queuely.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class QueueSection {
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Double averageServiceTime;
    private Boolean isActive;

    @ManyToOne
    @JoinColumn(name = "organization_id", nullable = false)
    private Organization organization;

    @OneToMany(mappedBy = "queueSection", cascade = CascadeType.ALL)
    private List<QueueEntry> queueEntries;

    public QueueSection(Long id, String name, Double averageServiceTime, Boolean isActive, Organization organization, List<QueueEntry> queueEntries) {
        this.id = id;
        this.name = name;
        this.averageServiceTime = averageServiceTime;
        this.isActive = isActive;
        this.organization = organization;
        this.queueEntries = queueEntries;
    }
    public QueueSection() {
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

    public Double getAverageServiceTime() {
        return averageServiceTime;
    }

    public void setAverageServiceTime(Double averageServiceTime) {
        this.averageServiceTime = averageServiceTime;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public Organization getOrganization() {
        return organization;
    }

    public void setOrganization(Organization organization) {
        this.organization = organization;
    }

    public List<QueueEntry> getQueueEntries() {
        return queueEntries;
    }

    public void setQueueEntries(List<QueueEntry> queueEntries) {
        this.queueEntries = queueEntries;
    }
}
