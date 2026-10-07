package com.eyubx.bookingsystem.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="experts")
public class Expert extends BaseEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String expertise;

    @Column(length=2000)
    private String description;

    private String email;

    private String phone;

    @OneToOne
    @JoinColumn(name="user_id", nullable = false)
    private User user;

    // TODO: replace this later with TimeSlot Entity when scale.
    @Column(columnDefinition = "jsonb")
    @JdbcTypeCode(SqlTypes.JSON)
    private List<String> availableHours = new ArrayList<>();

    public Expert() { }

    public Expert setName(String name) {
        if (name != null)
            this.name = name;
        return this;
    }

    public Expert setExpertise(String expertise) {
        this.expertise = expertise;
        return this;
    }

    public Expert setDescription(String description) {
        if (description != null)
            this.description = description;
        return this;
    }

    public Expert setEmail(String email) {
        if (email != null)
            this.email = email;
        return this;
    }

    public Expert setPhone(String phone) {
        if (phone != null)
            this.phone = phone;
        return this;
    }

    public Expert setUser(User user) {
        this.user = user;
        return this;
    }

    public Expert setAvailableHours(List<String> availableHours) {
        if (!availableHours.isEmpty())
            this.availableHours = availableHours;
        return this;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getExpertise() {
        return expertise;
    }

    public String getDescription() {
        return description;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public User getUser() {
        return user;
    }

    public List<String> getAvailableHours() {
        return availableHours;
    }
}
