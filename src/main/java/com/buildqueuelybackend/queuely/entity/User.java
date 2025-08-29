package com.buildqueuelybackend.queuely.entity;


import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "users")

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Column(unique = true, nullable = false)
    private String email;
    @Enumerated(EnumType.STRING)
    private Role role; // USER or ADMIN

    @OneToMany(mappedBy = "admin", cascade = CascadeType.ALL)
    private List<Organization> organization;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<QueueEntry> queueEntries;
    public User() {
    }
    public User(Long id, String name, String email, Role role, List<Organization> organization, List<QueueEntry> queueEntries) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.role = role;
        this.organization = organization;
        this.queueEntries = queueEntries;
    }

    public User(String name, String email, Role role) {
        this.name = name;
        this.email = email;
        this.role = role;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public List<Organization> getOrganization() {
        return organization;
    }

    public void setOrganization(List<Organization> organization) {
        this.organization = organization;
    }

    public List<QueueEntry> getQueueEntries() {
        return queueEntries;
    }

    public void setQueueEntries(List<QueueEntry> queueEntries) {
        this.queueEntries = queueEntries;
    }
}
