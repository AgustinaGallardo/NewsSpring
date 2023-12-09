package com.example.newsspring.controller;

import com.example.newsspring.Exceptions.MyException;
import com.example.newsspring.dtos.NewsDto;
import com.example.newsspring.entity.News;
import com.example.newsspring.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/news")
public class NewsController {

    @Autowired
    NewsService newsService;

    @GetMapping("/register")
    public String register(){
        return "news_form";
    }

    @PostMapping("/create")
    public ResponseEntity<NewsDto> createNews(@RequestBody NewsDto newsDto){
        try {
            newsService.createNews(newsDto);
            return ResponseEntity.ok(newsDto);
        } catch (MyException ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    /**
     *
      * @param model
     * @return

    @GetMapping("/list")
    public String listNews(ModelMap model){
        List<News> listNews = newsService.listNews();
        model.addAttribute("news",listNews);
        return "news_list.html";
    }

    @GetMapping("/modify/{id}")
    public String modify(@PathVariable String id, ModelMap modelo){
        modelo.put("news",newsService.getOne(id));
        return "news_modify.html";
    }

    @PostMapping("/modifyNews/{id}")
    public String modifyNews(@PathVariable String id, String title,String body, ModelMap modelo){
        try{
            newsService.modificateNews(title,body, id);
            return "redirect:/news/list";
        }catch (MyException ex) {
            modelo.put("error", ex.getMessage());
            return "news_modify.html";
        }
    }*/



}
