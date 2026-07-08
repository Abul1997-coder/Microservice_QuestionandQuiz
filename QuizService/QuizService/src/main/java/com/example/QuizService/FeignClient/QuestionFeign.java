package com.example.QuizService.FeignClient;

import com.example.QuizService.DTO.QuestionDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//After Edureka
//@FeignClient(name = "QuestionService", url = "http://localhost:7081")

//Before Edureka
@FeignClient(name = "QuestionService")


public interface QuestionFeign {

    @GetMapping("/question/{id}")
    QuestionDTO getQuestion(@PathVariable Long id);
}