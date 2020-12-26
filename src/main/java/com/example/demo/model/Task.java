package com.example.demo.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Data
@Entity
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate date;
    private String description;
    private boolean done;

    public void setId(Long id){
        this.id = id;
    }
    public Long getId(){
        return this.id;
    }

    public boolean isDone(){
        return this.done;
    }
}
