package com.example.mailsend.service;

import com.example.mailsend.model.CabData;
import com.example.mailsend.model.HeatData;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@Service
public class HeatService {
    private final WebClient webClient;


    public HeatService(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("http://localhost:8090").build();
    }

    public HeatData fetchData() {
        return webClient.get()
                .uri("/api/heat")
                .retrieve()
                .bodyToMono(HeatData.class)
                .block();
    }
}
