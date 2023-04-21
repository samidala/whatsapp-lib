package com.techdisqus.persistence.entities;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Whatsapp {
    private String whatsappbody;
    private String whatsapplang;
    private String whatsappsender;
    private String whatsappgateway;
    private String whatsappTemplateName;
    private String type;
}