package com.techdisqus.vo;

import lombok.Data;

import java.util.Map;


@Data
public class WhatsappMessage {

    private Map<String,String> values;
    private String whatsappTo;
}
