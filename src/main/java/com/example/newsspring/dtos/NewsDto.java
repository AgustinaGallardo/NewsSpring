package com.example.newsspring.dtos;
import lombok.Data;

@Data
public class NewsDto {

    private String title;
    private String body;
    private boolean isActive = true;
    private Long id_news;

}
