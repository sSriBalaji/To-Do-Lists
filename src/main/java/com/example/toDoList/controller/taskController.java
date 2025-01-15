package com.example.toDoList.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.toDoList.dto.addTaskDto;
import com.example.toDoList.dto.viewTaskDto;
import com.example.toDoList.service.taskService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;



@RestController
@RequestMapping("api/v1")
public class taskController {


    @Autowired
    private taskService taskservice;

    @PostMapping("/add")
    public String addTask(@RequestBody addTaskDto addtaskdto) {
        taskservice.addtask(addtaskdto);
        return "ok";
    }

    @GetMapping("/view")
    public List<viewTaskDto> viewTask() {
        return taskservice.view();

    }
    
    
}
