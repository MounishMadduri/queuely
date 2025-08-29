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

}
