package com.example.QuestionService.Controller;

import com.example.QuestionService.Entity.Question;
import com.example.QuestionService.Service.QuestionServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController  //REST controller that handles HTTP requests and returns JSON/XML responses.
@RequestMapping("/question")   //Sets the common URL (/question) for all APIs in this controller.

public class QuestionController {

    private final QuestionServiceImpl service;


    public QuestionController(QuestionServiceImpl service) {
        this.service = service;
    }

    //Create or added question
    @PostMapping("/add")
    public ResponseEntity <Question> addQuestion(@RequestBody  Question question)
    {
        Question save = service.saveQuestion(question);
        return new ResponseEntity<>(save, HttpStatus.CREATED);
    }


    //fetch all question
    @GetMapping("/all")
    public ResponseEntity <List<Question>> getAll()
    {
       List<Question> questions = service.getAll();
       return new ResponseEntity<>(questions,HttpStatus.OK);

    }


    //fetch question by id

    @GetMapping("/{id}")
    public ResponseEntity <Question> findByid(@PathVariable Long id)
    {
        Question questions = service.getQuestinById(id);

        if(questions != null)
        {
            return  new ResponseEntity<>(questions,HttpStatus.OK);
        }

        return  new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }

}

/*
ResponseEntity lets us send both the data and the HTTP status (like 200, 201, 404) to the client.

When we say "data and HTTP status", we mean:

Data (Response Body) → The actual object or JSON returned to the client.
HTTP Status → A code that tells whether the request was successful or failed.
* */