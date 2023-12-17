package com.example.mailsend.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)

public class CabData {
    @JsonProperty("CabId")
    private String cabId;

    @JsonProperty("RequestedBy")
    private String requestedBy;

    @JsonProperty("RequesterEmail")
    private String requesterEmail;

    @JsonProperty("Team")
    private String team;

    @JsonProperty("Approver")
    private String approver;

    @JsonProperty("ApproverEmail")
    private String approverEmail;

    @JsonProperty("Status")
    private String status;

    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    @JsonProperty("StartDate")
    private String startDate;

    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    @JsonProperty("EndDate")
    private String endDate;

    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    @JsonProperty("LastUpdateTime")
    private String lastUpdateTime;
}
