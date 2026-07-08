package com.example.QuizService.DTO;


import lombok.Data;

@Data
public class QuestionDTO {


    private Long id;
    private String questionTitle;
    private String option1;
    private String option2;
    private String answer;
}

/*

Question DTO	Receives data from the Question Service (Feign response).
QuizResponse DTO	Sends the combined response from the Quiz Service to the client.



Purpose:

Receives data from the Question Service using the Feign Client.
It is a Response DTO for the Feign call.

Example response from Question Service:

        {
        "id": 1,
        "questionTitle": "Java is?",
        "option1": "Programming Language",
        "option2": "Programming Language",
        "answer": "Programming Language"
        }

Feign converts this JSON into the Question DTO.


 */