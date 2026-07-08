package com.example.QuestionService.Service;

import com.example.QuestionService.Entity.Question;

import java.util.List;

public interface QuestionService {

    public Question saveQuestion(Question question);

    public List<Question> getAll();

    public Question getQuestinById(Long id);
}
