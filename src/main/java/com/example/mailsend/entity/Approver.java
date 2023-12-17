package com.example.mailsend.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "approver")
public class Approver {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int approvar_id;

    private String name;
    private String email;
    @OneToMany(mappedBy = "approver", cascade = CascadeType.ALL)
    private List<AppDetail> appDetails;




}
