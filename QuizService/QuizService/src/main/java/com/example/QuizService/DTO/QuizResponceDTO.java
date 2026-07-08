package com.example.QuizService.DTO;

import lombok.Data;

@Data
public class QuizResponceDTO {

    private Long id;
    private String quizTitle;
    private Long marks;
    private QuestionDTO question;
}

/*

Question DTO:=	Receives data from the Question Service (Feign response).
QuizResponse DTO:=	Sends the combined response from the Quiz Service to the client.



Why we use Question question
Because the Quiz Service wants to return both Quiz details and the related Question details in a single response.


the response becomes:

{
  "id": 1,
  "quizTitle": "Java Quiz",
  "marks": 10,
  "question": {
    "id": 101,
    "questionTitle": "What is Java?",
    "option1": "Programming Language",
    "answer": "Programming Language"
  }
}

Now the client receives both the quiz and its question in one API response.


 */