package com.example.mailsend.repository;

import com.example.mailsend.entity.Approver;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApproverRepo extends JpaRepository<Approver,Integer> {
}
