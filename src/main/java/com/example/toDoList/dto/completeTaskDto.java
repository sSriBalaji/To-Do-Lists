package com.example.toDoList.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class completeTaskDto {
    
    private int id;
    private String name;
    private String description;
}
