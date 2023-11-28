package com.example.emailVerificationPractice.Entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class News {
    @javax.persistence.Id
    @SequenceGenerator(
            name = "news_sequence",
            sequenceName = "news_sequence",
            allocationSize = 1
    )

    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator =  "news_sequence"
    )

    private Long id;
    private String headName;
    private String about;
    private String article;


}
