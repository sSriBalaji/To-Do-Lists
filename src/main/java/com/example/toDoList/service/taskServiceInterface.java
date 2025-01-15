package com.example.toDoList.service;

import java.util.List;

import com.example.toDoList.dto.addTaskDto;
import com.example.toDoList.dto.viewTaskDto;

public interface taskServiceInterface {
    String addtask(addTaskDto addtaskdto);
    List<viewTaskDto> view();
    boolean deletetask(int id);
}
