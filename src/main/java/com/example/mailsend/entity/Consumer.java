package com.example.mailsend.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "consumer")
@Data
public class Consumer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int consumer_id;

    private String name;
    private String email;

    @ManyToMany(mappedBy = "consumers")
    private List<AppDetail> appDetails;
}
