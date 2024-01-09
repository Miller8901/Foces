package com.example.emailVerificationPractice.Controller;

import com.example.emailVerificationPractice.Entity.ApiUser;
import com.example.emailVerificationPractice.Entity.News;
import com.example.emailVerificationPractice.Service.ApiServiceImpl;
import com.example.emailVerificationPractice.Service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/news")
@RestController
public class NewsPage {

    private final NewsService newsService;

    @Autowired
    public NewsPage(NewsService newsService) {
        this.newsService = newsService;
    }

    @GetMapping
    public List<News> retrieveNewsList(){
        return newsService.retrieveNews();
    }

    /*
    @PostMapping
    public void saveCApiUser(@RequestBody ApiUser apiUser){
     apiService.saveApiUser(apiUser);
        System.out.println("Added Successfully");
    }
    */

    @PostMapping("/create_news")
    @PreAuthorize("hasAnyAuthority('role_AdminTraineeContentCreator')")
    public void saveNews(@RequestBody News news){
        newsService.saveNews(news);
        System.out.println("saved Successfully");
    }

    @PutMapping("/update/{email}")
    public void updateNews(@PathVariable String newsUniqueId, @RequestBody News news){

        newsService.updateNews(newsUniqueId, news);

        //studentService.save(originalStudent);

    }

    @DeleteMapping("/delete/{headName}")
    @PreAuthorize("hasAnyAuthority('role_Admin')")
    public void deleteNewsByHeadName(@PathVariable("headName") String headName){

        newsService.deleteNewsByHeadName(headName);
    }

    @DeleteMapping("/delete/{newsUniqueId}")
    @PreAuthorize("hasAnyAuthority('role_Admin')")
    public void deleteNewsByUniqueId(@PathVariable("newsUniqueId") String newsUniqueId){

        newsService.deleteNewsByNewsUniqueId(newsUniqueId);
    }



}
