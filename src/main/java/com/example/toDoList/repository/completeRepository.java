package com.example.toDoList.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.toDoList.model.completedEvents;

public interface completeRepository extends JpaRepository<completedEvents,Integer>{

}
