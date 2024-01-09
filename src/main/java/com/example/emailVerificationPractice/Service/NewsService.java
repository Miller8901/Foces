package com.example.emailVerificationPractice.Service;

import com.example.emailVerificationPractice.Entity.ApiUser;
import com.example.emailVerificationPractice.Entity.News;
import com.example.emailVerificationPractice.Repository.NewsRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewsService {

   private final NewsRepository newsRepository;

    public NewsService(NewsRepository newsRepository) {
        this.newsRepository = newsRepository;
    }

    public List<News> retrieveNews(){
        return newsRepository.findAll();
    }

    public void saveNews(News news){
        newsRepository.save(news);
    }

    public void updateNews(String newsUniqueId, News news){

       News retrievedNews =  newsRepository.findByNewsUniqueId(newsUniqueId);
       retrievedNews.setAuthor(news.getAuthor());
       retrievedNews.setHeadName(news.getHeadName());
       retrievedNews.setArticle(news.getArticle());

       newsRepository.save(news);
    }

    public void deleteNewsByHeadName(String headName) {
        News news = newsRepository.findByHeadName(headName);
        newsRepository.deleteById(news.getId());
    }

    public void deleteNewsByNewsUniqueId(String newsUniqueId) {
        News news = newsRepository.findByNewsUniqueId(newsUniqueId);
        newsRepository.deleteById(news.getId());
    }
}
