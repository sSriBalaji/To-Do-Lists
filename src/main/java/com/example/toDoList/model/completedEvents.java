package com.example.toDoList.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="completed")
public class completedEvents {

    @Id
    @Column(name="id")
    private int id;

    @Column(name="name",length=50)
    private String name;

    @Column(name = "description",length = 200)
    private String description;

    public completedEvents() {
    }

    public completedEvents(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public completedEvents(int id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
