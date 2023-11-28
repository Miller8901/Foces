package com.example.emailVerificationPractice.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.SequenceGenerator;
import java.time.LocalDate;


public class RecentActivity {
    @javax.persistence.Id
    @SequenceGenerator(
            name = "recent_activity_sequence",
            sequenceName = "recent_activity_sequence",
            allocationSize = 1
    )

    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator =  "recent_activity_sequence"
    )

    private Long Id;
    private Object object;
    private LocalDate date;
}
