package com.Capg.Repositary;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Capg.Model.Question;
@Repository
public interface QuestionRepositary extends JpaRepository<Question,Integer>
{
  
}
