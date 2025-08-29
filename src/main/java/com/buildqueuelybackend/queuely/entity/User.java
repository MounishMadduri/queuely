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


}
