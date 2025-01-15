package com.example.toDoList.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.toDoList.model.list;

public interface taskRepository extends JpaRepository<list,Integer>{

}
