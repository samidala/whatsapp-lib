package com.techdisqus.whatsapp.model;

import lombok.Data;

import java.util.ArrayList;

public class DeliveryMessage {
    @Data
    public static class Change{
        private Value value;
        private String field;
    }
    @Data
    public static class Conversation{
        private String id;
        private String expiration_timestamp;
        private Origin origin;
    }
    @Data
    public static class Entry{
        private String id;
        private ArrayList<Change> changes;
    }
    @Data
    public static  class Metadata{
        private String display_phone_number;
        private String phone_number_id;
    }
    @Data
    public static class Origin{
        private String type;
    }
    @Data
    public static class Pricing{
        private boolean billable;
        private String pricing_model;
        private String category;
    }
    @Data
    public static class MessageStatusNotification{
        private String object;
        private ArrayList<Entry> entry;
    }
    @Data
    public static class Status{
        private String id;
        private String status;
        private String timestamp;
        private String recipient_id;
        private Conversation conversation;
        private Pricing pricing;
    }
    @Data
    public static class Value{
        private String messaging_product;
        private Metadata metadata;
        private ArrayList<Status> statuses;
    }

}
