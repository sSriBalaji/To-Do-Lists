package com.example.toDoList.service;

import java.util.List;

import com.example.toDoList.dto.addTaskDto;
import com.example.toDoList.dto.completeTaskDto;
import com.example.toDoList.dto.updateTaskDto;
import com.example.toDoList.dto.viewCompletedTaskDto;
import com.example.toDoList.dto.viewTaskDto;

public interface taskServiceInterface {
    String addtask(addTaskDto addtaskdto);
    List<viewTaskDto> view();
    // updateTaskDto edittask(int id);
    boolean deletetask(int id);

    boolean completetask(int id);
    void completetask(completeTaskDto completetaskdto);
    List<viewCompletedTaskDto> viewcompleted();
    boolean undo(int id);
}
