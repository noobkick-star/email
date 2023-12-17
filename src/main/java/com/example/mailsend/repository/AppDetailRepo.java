package com.example.mailsend.repository;

import com.example.mailsend.entity.AppDetail;
import com.example.mailsend.entity.Consumer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AppDetailRepo extends JpaRepository<AppDetail, Integer> {

    @Query("SELECT a FROM AppDetail a JOIN FETCH a.consumers WHERE a.name = ?1")
    AppDetail getByAppName(String name);
}
