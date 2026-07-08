package com.example.QuizService.Controller;


import com.example.QuizService.DTO.QuizResponceDTO;
import com.example.QuizService.Entity.Quiz;
import com.example.QuizService.Service.QuizService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/quiz")
public class QuizController {


    private final QuizService service;


    public QuizController(QuizService service) {
        this.service = service;

    }



    @PostMapping("/add")
    public ResponseEntity <Quiz> add(@RequestBody Quiz quiz){

        Quiz save =  service.saveQuiz(quiz);
        return new ResponseEntity<>(save, HttpStatus.CREATED);
    }




    @GetMapping("/{id}")
    public ResponseEntity <QuizResponceDTO> getQuiz(@PathVariable Long id){

        QuizResponceDTO quizs = service.get(id);
        if(quizs != null)
        {
            return  new ResponseEntity<>(quizs, HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }







}
