package com.techdisqus.whatsapp;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class WhatsappMessage {
    @Data
    public static class WhatsappTemplate {
        private String Name;
        private Language language;
        private List<Component> components;
    }

    @Data
    public static class TextMessage {
        private final String body;
        @JsonProperty("preview_url")
        private final boolean previewUrl;
    }

    public static TextMessage getTextMessage(String body, boolean previewUrl){
        return new TextMessage(body,previewUrl);
    }


    public static WhatsappTemplate getTemplate(Map<String, String> params, String whatsappTemplateName) {
        Component component = new Component();
        if(params != null && !params.isEmpty()) {
            component.setParameters(setParameters(params));
        }

        WhatsappTemplate template = new WhatsappTemplate();
        template.setName(whatsappTemplateName);
        template.setLanguage(new Language());
        template.setComponents(Collections.singletonList(component));
        return template;
    }

    private static List<Parameter> setParameters(Map<String, String> params) {
        List<Parameter> parameters = new ArrayList<>(params.size());
        params.forEach((key, value) -> parameters.add(Parameter.builder().text(value).type("text").build()));
        return parameters;
    }

    @Data
    public static class Language {
        private String code = "en_US";
        private String policy = "deterministic";
    }

    @Data
    @Builder
    public static class Parameter {
        private String type = "text";
        private String text;
    }

    @Data
    public static class Component {
        private String type = "body";
        private List<Parameter> parameters;


    }

    @Data
    public static class WhatsappMessagePayload {

        @JsonProperty("messaging_product")
        private String messageProduct = "whatsapp";
        private WhatsappTemplate template;

        @JsonProperty("recipient_type")
        private String recipientType;
        @JsonProperty("text")
        private TextMessage textMessage;
        private String to;
        private String type = "template";


    }
}