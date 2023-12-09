package com.example.newsspring.service;
import com.example.newsspring.Exceptions.MyException;
import com.example.newsspring.dtos.NewsDto;
import com.example.newsspring.entity.News;
import com.example.newsspring.mapper.NewsMapper;
import com.example.newsspring.repository.NewsRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Service
public class NewsService {
    @Autowired
    NewsRepository newsRepository;
    @Transactional
        public void createNews(String title, String body) throws MyException {
            validation(title,body);
            News news = new News();
            news.setTitle(title);
            news.setBody(body);
            newsRepository.save(news);
    }
    private void validation(String title, String body) throws MyException {
        if(title.isEmpty()){
            throw new MyException("El titulo no puede ser nulo");
        }
        if(body.isEmpty()){
            throw new MyException("El cuerpo de la noticia no puede ser nulo");
        }
    }
    @Transactional
    public void modificateNews(String title,String body, String id) throws MyException {
        validation(title, body);

        Optional<News> respuesta = newsRepository.findById(id);

        if (respuesta.isPresent()) {
            News news = respuesta.get();
            news.setTitle(title);
            news.setBody(body);
            newsRepository.save(news);
        }

    }
    public List<News> listNews(){
        List<News> listNews= new ArrayList<>();
        listNews = newsRepository.findAll();
        return listNews;
    }

    public void eliminateNews(String id)throws MyException {

    }

    public News getOne(String id) {
        return newsRepository.getById(id);
    }

    public void createNews(NewsDto newsDto) throws MyException {
        News news = NewsMapper.toNews(newsDto);
        validation(newsDto.getTitle(), newsDto.getBody());
        newsRepository.save(news);
    }


}
