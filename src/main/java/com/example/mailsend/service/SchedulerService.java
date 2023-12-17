package com.example.mailsend.service;

import com.example.mailsend.entity.AppDetail;
import com.example.mailsend.entity.Consumer;
import com.example.mailsend.model.CabData;
import com.example.mailsend.model.HeatData;
import com.example.mailsend.repository.AppDetailRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
@Slf4j
public class SchedulerService {

    private final HeatService heatService;
    private final AppDetailRepo appDetailRepo;

    private final EmailService emailService;
    public SchedulerService(HeatService heatService, AppDetailRepo appDetailRepo, EmailService emailService) {
        this.heatService = heatService;
        this.appDetailRepo = appDetailRepo;
        this.emailService = emailService;
    }

    @Scheduled(fixedRate = 60000) // Run every 5 seconds
    public void performTask() {

        HeatData heatData = heatService.fetchData();
        List<CabData> approved = heatData.getData().stream().filter(e -> e.getStatus().equals("Approved"))
                .filter(e -> minDiff(e.getLastUpdateTime()) < 10)
                .toList();
        if (!approved.isEmpty()) {
            for(CabData cabData : approved) {
               AppDetail app= appDetailRepo.getByAppName(cabData.getTeam());
               List<String> emails = app.getConsumers().stream().map(Consumer::getEmail).toList();
               emails.forEach(this::sendEmail);
            }
//            AppDetail incs = appDetailRepo.getByAppName("INCS");
//            log.info("app team : {}", incs);


        }

    }

    private void sendEmail(String email){
        //emailService.sendMail(file, to, cc, subject, body)
        emailService.sendMail(null, email, null, "this is subject ", "this is body");
    }

    private long minDiff(String start) {
        var dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        var startdate = LocalDateTime.parse(start, dateTimeFormatter);
        var enddate = LocalDateTime.now();
        var duration = Duration.between(startdate, enddate);
        return duration.toMinutes();
    }


}
