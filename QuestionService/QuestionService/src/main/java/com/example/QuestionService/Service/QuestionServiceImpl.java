package com.example.QuestionService.Service;

import com.example.QuestionService.Entity.Question;
import com.example.QuestionService.Repository.QuestionRepository;
import org.springframework.stereotype .Service;

import java.util.List;

@Service
public class QuestionServiceImpl  implements QuestionService {

private final  QuestionRepository repository;

public QuestionServiceImpl(QuestionRepository repository)
{
    this.repository = repository;
}



//Save the all question
    @Override
    public Question saveQuestion(Question question) {
        return repository.save(question);
    }


    //Get the all questions
    @Override
    public List<Question> getAll() {
        return repository.findAll();
    }


    //question findBy id
    @Override
    public Question getQuestinById(Long id) {
        return repository.findById(id).orElse(null);
    }
}




/*

Loose coupling:- Classes depend on an interface, not on a specific implementation, so one class can be changed without affecting another.


This interface only declares the methods.

The actual logic is written in QuestionServiceImpl.

If you later change QuestionServiceImpl or create another implementation, the controller doesn't need to change.
*
QuestionService = What methods are available.
QuestionServiceImpl = How those methods work.
*
*
* We use a Service Interface to define the service methods. The implementation
* class contains the actual business logic. It provides loose coupling, makes the
* code easier to maintain, allows changing implementations without affecting Controller, and improves testing.
*
*
* This gives loose coupling, makes the code easier to maintain, allows us to change or add implementations without changing the controller, and makes unit testing easier.
*





 */