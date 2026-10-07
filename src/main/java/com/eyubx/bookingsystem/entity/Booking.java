package com.eyubx.bookingsystem.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "bookings")
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String key;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="expert_id", nullable=false)
    private Expert expert;

    private String name;

    private String email;

    private String phone;

    @Column(length = 500)
    private String note;

    @Column(nullable = false)
    private LocalDate bookingDate;

    // TODO: replace with TimeSlot FK when migrating to entity approach
    @Column(nullable = false)
    private String timeSlot;

    public Booking() { }

    public String getTimeSlot() {
        return timeSlot;
    }

    public Booking setTimeSlot(String timeSlot) {
        this.timeSlot = timeSlot;
        return this;
    }

    public LocalDate getBookingDate() {
        return bookingDate;
    }

    public Booking setBookingDate(LocalDate bookingDate) {
        this.bookingDate = bookingDate;
        return this;
    }

    public String getNote() {
        return note;
    }

    public Booking setNote(String note) {
        this.note = note;
        return this;
    }

    public String getPhone() {
        return phone;
    }

    public Booking setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public Booking setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getName() {
        return name;
    }

    public Booking setName(String name) {
        this.name = name;
        return this;
    }

    public Expert getExpert() {
        return expert;
    }

    public Booking setExpert(Expert expert) {
        this.expert = expert;
        return this;
    }

    public String getKey() {
        return key;
    }

    public Booking setKey(String key) {
        this.key = key;
        return this;
    }

    public Long getId() {
        return id;
    }

}
