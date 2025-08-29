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
    public QueueEntry() {
    }
    public QueueEntry(Long id, String tokenNumber, LocalDateTime joinedAt, LocalDateTime exitAt, Status status, QueueSection queueSection, User user) {
        this.id = id;
        this.tokenNumber = tokenNumber;
        this.joinedAt = joinedAt;
        this.exitAt = exitAt;
        this.status = status;
        this.queueSection = queueSection;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTokenNumber() {
        return tokenNumber;
    }

    public void setTokenNumber(String tokenNumber) {
        this.tokenNumber = tokenNumber;
    }

    public LocalDateTime getJoinedAt() {
        return joinedAt;
    }

    public void setJoinedAt(LocalDateTime joinedAt) {
        this.joinedAt = joinedAt;
    }

    public LocalDateTime getExitAt() {
        return exitAt;
    }

    public void setExitAt(LocalDateTime exitAt) {
        this.exitAt = exitAt;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public QueueSection getQueueSection() {
        return queueSection;
    }

    public void setQueueSection(QueueSection queueSection) {
        this.queueSection = queueSection;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
