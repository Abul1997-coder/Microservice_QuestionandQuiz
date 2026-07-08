package com.example.QuestionService.Repository;

import com.example.QuestionService.Entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuestionRepository extends JpaRepository<Question,Long> {

    /*

Default Methods provided by JPA

save(question);              // Insert or Update

findById(id);                // Find by ID

findAll();                   // Get all records

deleteById(id);              // Delete by ID

delete(question);            // Delete an object

count();                     // Count total records

existsById(id);              // Check if ID exists

findAllById(ids);            // Find multiple records by IDs

deleteAll();                 // Delete all records







     */
}

