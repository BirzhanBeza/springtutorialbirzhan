package com.example.demo.controller;

import com.example.demo.model.Task;
import com.example.demo.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class TaskController {

    @Autowired
    private TaskRepository taskRepository;

    @PostMapping("/tasks")
    public Task create(@RequestBody Task task) {
        return taskRepository.save(task);
    }

    @GetMapping("/tasks")
    public Iterable<Task> getAllTasks(){
        return taskRepository.findAll();
    }

    @GetMapping("/tasks/{id}")
    public Task getTaskById(@PathVariable Long id){
        return taskRepository.findById(id).orElse(null);
    }

    @PutMapping("/tasks/{id}")
    public Task update(@PathVariable Long id, @RequestBody Task task){
        task.setId(id);
        return taskRepository.save(task);
    }

    @DeleteMapping("tasks/{id}")
    public void delete(@PathVariable Long id){
        taskRepository.deleteById(id);
    }

    @PatchMapping("tasks/{id}")
    public void patch(@PathVariable Long id, @RequestBody Task task){
        if(task.isDone()){
            taskRepository.markAsDone(id);
        }
    }

    @PatchMapping("tasks/{id}:mark-as-done")
    public void patch(@PathVariable Long id){
        taskRepository.markAsDone(id);
    }
}
