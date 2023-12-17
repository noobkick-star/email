package com.example.mailsend.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "appdetail")
@Data
public class AppDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int app_id;

    private String name;
    private String email;

    @ManyToOne
    @JoinColumn(name = "approver_id")
    private Approver approver;

    @ManyToMany
    @JoinTable(
            name = "appdetail_consumer",
            joinColumns = @JoinColumn(name = "app_id"),
            inverseJoinColumns = @JoinColumn(name = "consumer_id")
    )
    private List<Consumer> consumers;



}
