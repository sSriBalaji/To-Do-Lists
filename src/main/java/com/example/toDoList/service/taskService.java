package com.example.toDoList.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.toDoList.dto.addTaskDto;
import com.example.toDoList.dto.viewTaskDto;
import com.example.toDoList.model.list;
import com.example.toDoList.repository.taskRepository;

@Service
public class taskService implements taskServiceInterface{

    @Autowired
    private taskRepository taskrepo;

    @Override
    public String addtask (addTaskDto addtaskdto){
        list task = new list(
            addtaskdto.getName(),
            addtaskdto.getDescription()
        );
        taskrepo.save(task);
        return "ok";
    }


    @Override
    public List<viewTaskDto> view() {
            List<list> allTasks = taskrepo.findAll();

            List<viewTaskDto> tasks = new ArrayList<>();
            
            for(list task : allTasks){
                viewTaskDto viewtask = new viewTaskDto(
                    task.getId(),
                    task.getName(),
                    task.getDescription()
                );
                tasks.add(viewtask);
            }
            return tasks;
        
    }
}
