package com.techdisqus.persistence.entities;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Field;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class WhatsappGateway {
    private String token;
    private String from;
    private String uri;
    private String whatsappTemplateName;
}
