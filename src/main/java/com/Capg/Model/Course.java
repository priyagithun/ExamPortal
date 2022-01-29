package com.Capg.Model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Course
{
  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
   private int course_id;
  
  @Column(name="course_type")
  private String course_type;
  
  @OneToOne(cascade=CascadeType.ALL,mappedBy="course")
  @JsonManagedReference
  private Question question;

public int getCourse_id() {
	return course_id;
}

public void setCourse_id(int course_id) {
	this.course_id = course_id;
}

public String getCourse_type() {
	return course_type;
}

public void setCourse_type(String course_type) {
	this.course_type = course_type;
}

public Question getQuestion() {
	return question;
}

public void setQuestion(Question question) {
	this.question = question;
}

@Override
public String toString() {
	return "Course [course_id=" + course_id + ", course_type=" + course_type + ", question=" + question + "]";
}
  
  
  
  

}
