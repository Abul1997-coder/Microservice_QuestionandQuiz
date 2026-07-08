package com.example.QuizService.Service;

import com.example.QuizService.DTO.QuizResponceDTO;
import com.example.QuizService.Entity.Quiz;

public interface QuizService {


    public Quiz saveQuiz(Quiz quiz);
    public QuizResponceDTO get(Long id);
}
