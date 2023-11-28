package com.example.emailVerificationPractice.Service;

import com.example.emailVerificationPractice.Repository.NewsRepository;

public class NewsService {

   private final NewsRepository newsRepository;

    public NewsService(NewsRepository newsRepository) {
        this.newsRepository = newsRepository;
    }
}
