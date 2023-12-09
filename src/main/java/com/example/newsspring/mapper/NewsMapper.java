package com.example.newsspring.mapper;

import com.example.newsspring.dtos.NewsDto;
import com.example.newsspring.entity.News;

public class NewsMapper {

    public static NewsDto toNewsDTO(News news) {
        NewsDto newsDTO = new NewsDto();

        newsDTO.setTitle(news.getTitle());
        newsDTO.setBody(news.getBody());
        newsDTO.setActive(news.getIsActive());
        newsDTO.setId_news(news.getId());

        return newsDTO;
    }

    public static News toNews(NewsDto newsDto) {
        News news = new News();

        news.setTitle(newsDto.getTitle());
        news.setBody(newsDto.getBody());
        news.setIsActive(newsDto.isActive());
        news.setId(news.getId());

        return news;
    }
}
