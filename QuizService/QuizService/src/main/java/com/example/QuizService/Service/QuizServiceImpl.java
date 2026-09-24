package com.example.QuizService.Service;

import com.example.QuizService.DTO.QuestionDTO;
import com.example.QuizService.DTO.QuizResponceDTO;
import com.example.QuizService.Entity.Quiz;
import com.example.QuizService.FeignClient.QuestionFeign;
import com.example.QuizService.Repository.QuizRepository;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.aspectj.weaver.patterns.TypePatternQuestions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuizServiceImpl implements QuizService {

    @Autowired
    private QuizRepository repository;

    @Autowired
    private QuestionFeign feign;

    @Override
    public Quiz saveQuiz(Quiz quiz) {
        return repository.save(quiz);
    }

    @Override

// CircuitBreak
    @CircuitBreaker(name ="questionService", fallbackMethod = "questionFallback")
    public QuizResponceDTO get(Long id) {

        Quiz quiz = repository.findById(id).orElse(null);

        if (quiz == null) {
            return null;
        }

        // Feign call
        QuestionDTO question = feign.getQuestion(quiz.getQuestionId());


        QuizResponceDTO response = new QuizResponceDTO();
        response.setId(quiz.getId());
        response.setQuizTitle(quiz.getQuizTitle());
        response.setMarks(quiz.getMarks());
        response.setQuestion(question);

        return response;
    }


        //FallBack Methods Calls
        public QuizResponceDTO  questionFallback(Long id, Exception ex)
        {
            QuizResponceDTO responceDTO1 = new QuizResponceDTO();

            responceDTO1.setId(id);
            responceDTO1.setQuizTitle("Queston Service is Down");
            responceDTO1.setMarks(0L);

            QuestionDTO questionDTO = new QuestionDTO();
            questionDTO.setQuestionTitle("No Question Available");
            responceDTO1.setQuestion(questionDTO);

            return  responceDTO1;
        }
    }
