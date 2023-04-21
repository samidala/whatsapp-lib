package com.techdisqus.whatsapp.model.templates;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

public class TemplateResponse {
    @Data
    public static class Button{
        private String type;
        private String text;
        private String url;
    }
    @Data
    public static class Component{
        private String type;
        private String text;
        private Example example;
        private String format;
        private ArrayList<Button> buttons;
    }
    @Data
    public static class Cursors{
        private String before;
        private String after;
    }
    @Data
    public static class Template {
        private String name;
        private ArrayList<Component> components;
        private String language;
        private String status;
        private String category;
        private String id;
    }
    @Data
    public static class Example{
        private ArrayList<ArrayList<String>> body_text;
    }
    @Data
    public static class Paging{
        private Cursors cursors;
    }
    @Data
    public static class Templates {
        private List<Template> data;
        private Paging paging;
    }
}
