package com.example.newsspring.controller;

import com.example.newsspring.Exceptions.MyException;
import com.example.newsspring.entity.News;
import com.example.newsspring.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/news")
public class NewsController {

    @Autowired
    NewsService newsService;

    @GetMapping("/register")
    public String register(){
        return "news_form";
    }
    @PostMapping("/create")
    public String createNews(@RequestParam String title,@RequestParam String body){
        try {
            newsService.createNews(title,body);
        } catch (MyException e) {
            throw new RuntimeException(e);
        }
        return "index.html";
    }
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
    }



}
