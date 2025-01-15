package com.example.toDoList.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.toDoList.dto.addTaskDto;
import com.example.toDoList.dto.completeTaskDto;
import com.example.toDoList.dto.updateTaskDto;
import com.example.toDoList.dto.viewTaskDto;
import com.example.toDoList.model.completedEvents;
import com.example.toDoList.model.list;
import com.example.toDoList.repository.completeRepository;
import com.example.toDoList.repository.taskRepository;

@Service
public class taskService implements taskServiceInterface{

    @Autowired
    private taskRepository taskrepo;

    @Autowired
    private completeRepository completerepo;

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


    @Override
    public boolean deletetask(int id) {
        if(taskrepo.existsById(id)){
            taskrepo.deleteById(id);
            return true;
        }
        return false;
    }


    @Override
    public boolean edittask(updateTaskDto updatetaskdto) {
        if(taskrepo.existsById(updatetaskdto.getId())){
            list task = taskrepo.getById(updatetaskdto.getId());
            task.setName(updatetaskdto.getName());
            task.setDescription(updatetaskdto.getDescription());
            taskrepo.save(task);
            return true;
        }
        return false;
    }


    @Override
    @Transactional
    public boolean completetask(int id) {
        if(taskrepo.existsById(id)){
            list task = taskrepo.getById(id);
            completedEvents complete = new completedEvents(
                task.getId(),
                task.getName(),
                task.getDescription()
            );
            completerepo.save(complete);
            taskrepo.deleteById(id);
            return true;
        }
        return false;
        
    }

    @Override
    @Transactional //when there is a failure then it completely rolls back it is useful when two operation are taking place
    public void completetask(completeTaskDto completetaskdto) {
        if(taskrepo.existsById(completetaskdto.getId())){
            list task = taskrepo.getById(completetaskdto.getId());
            completedEvents complete = new completedEvents(
                task.getId(),
                task.getName(),
                task.getDescription()
            );
            completerepo.save(complete);
            taskrepo.deleteById(completetaskdto.getId());
            
        }  
    }


    
}
