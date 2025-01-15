package com.example.toDoList.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class viewTaskDto {
    private int id;
    private String name;
    private String description;
}
