package com.techdisqus.whatsapp.model;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import io.swagger.annotations.ApiModel;
import lombok.*;

import java.time.Instant;

@ApiModel(description = "Represents a whatsapp request creation response")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@JsonInclude(Include.NON_NULL)
public class WhatsappNotificationResponse {

    String notificationId;
    String status;
    String message;
    Instant requestedTime;
    Instant sentTime;
}
