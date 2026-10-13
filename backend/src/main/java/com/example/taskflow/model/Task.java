package com.example.taskflow.model;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
@Entity public class Task {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
 @Column(nullable=false) private String title;
 private boolean completed;
 public Long getId(){return id;} public String getTitle(){return title;} public void setTitle(String title){this.title=title;} public boolean isCompleted(){return completed;} public void setCompleted(boolean completed){this.completed=completed;}
}
