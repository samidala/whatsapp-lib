package com.techdisqus.whatsapp.model;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WhatsappApiResponse {

    @JsonProperty("messaging_product")
    private String messagingProduct;
    @JsonProperty("messages")
    private List<Message> messages;

    @Data
    public static class Message{
        private String id;
    }


}