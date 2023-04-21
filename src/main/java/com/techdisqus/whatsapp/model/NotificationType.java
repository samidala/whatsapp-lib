package com.techdisqus.whatsapp.model;


public enum NotificationType {
    EMAIL("email"), SMS("sms"), WHATSAPP("whatsapp"),ALL("all");

    private final String type;
    NotificationType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}