package com.buildqueuelybackend.queuely.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class QueueEntry {
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long id;
    private String tokenNumber;
    private LocalDateTime joinedAt;
    private LocalDateTime exitAt;

    @Enumerated(jakarta.persistence.EnumType.STRING)
    private Status status; // e.g., "WAITING", "IN_SERVICE", "COMPLETED", "CANCELLED"

    @ManyToOne
    @JoinColumn(name = "queue_section_id", nullable = false)
    private QueueSection queueSection;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
}
