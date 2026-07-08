package com.example.QuizService.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data

@Entity
@Table(name="quiz")
public class Quiz {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String quizTitle;
    private Long questionId;
    private Long marks;

}


/*

why use private:-

We use private to hide data and allow controlled access through getters and setters (encapsulation).
 */
