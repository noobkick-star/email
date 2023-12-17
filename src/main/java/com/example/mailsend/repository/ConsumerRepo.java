package com.example.mailsend.repository;

import com.example.mailsend.entity.Consumer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ConsumerRepo extends JpaRepository<Consumer, Integer> {
}
