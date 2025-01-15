package com.example.toDoList.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.toDoList.dto.addTaskDto;
import com.example.toDoList.dto.completeTaskDto;
import com.example.toDoList.dto.updateTaskDto;
import com.example.toDoList.dto.viewTaskDto;
import com.example.toDoList.service.taskService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;



@CrossOrigin
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

    @PutMapping("/edit")
    public String editTask(@RequestBody updateTaskDto updatetaskdto) {
        boolean response = taskservice.edittask(updatetaskdto);
        return (response)?"updated":"the id doesn't exsists";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteTask(@PathVariable(value = "id")int id){
        boolean response = taskservice.deletetask(id);
        return (response)?"the task is deleted":"the task doesn't exsists or not deleted TRY AGAIN";
    }

    //compelete the task by id:
    @PostMapping("/complete/{id}")
    public String completeTask(@PathVariable(value="id")int id){
        taskservice.completetask(id);
        return "completed";
    }

    //complete the task by dto
    @PostMapping("/complete")
    public void completeTask(@RequestBody completeTaskDto compltetaskdto) {
        taskservice.completetask(compltetaskdto);
    }
    
    
    
}
