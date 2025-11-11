package com.example.onlineshop.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "customer_support_tickets")
public class CustomerSupportTicket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long orderId;

    @Column(nullable = false)
    private String query;

    private String description;

    private LocalDateTime raisedOn = LocalDateTime.now();

    private LocalDateTime resolvedOn;

    private String resolution;

    // 🧩 Constructors
    public CustomerSupportTicket() {}

    public CustomerSupportTicket(Long orderId, String query, String description) {
        this.orderId = orderId;
        this.query = query;
        this.description = description;
    }

    // 🧩 Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getOrderId() { return orderId; }
    public void setOrderId(Long orderId) { this.orderId = orderId; }

    public String getQuery() { return query; }
    public void setQuery(String query) { this.query = query; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public LocalDateTime getRaisedOn() { return raisedOn; }
    public void setRaisedOn(LocalDateTime raisedOn) { this.raisedOn = raisedOn; }

    public LocalDateTime getResolvedOn() { return resolvedOn; }
    public void setResolvedOn(LocalDateTime resolvedOn) { this.resolvedOn = resolvedOn; }

    public String getResolution() { return resolution; }
    public void setResolution(String resolution) { this.resolution = resolution; }
}
