package com.example.toDoList.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.toDoList.dto.addTaskDto;
import com.example.toDoList.dto.updateTaskDto;
import com.example.toDoList.dto.viewCompletedTaskDto;
import com.example.toDoList.dto.viewTaskDto;
import com.example.toDoList.service.taskService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;



@CrossOrigin
@Controller
@RequestMapping("/Tasks")
public class taskController {


    @Autowired
    private taskService taskservice;


    @GetMapping("/")
    public String homePage(){
        return "index";
    }
    @GetMapping("/add")
    public String showAddTaskPage() {
    return "addTask"; // Corresponds to addTask.html
}
    @PostMapping("/add")
    public String addTask(@RequestParam String name, @RequestParam String description) {
        addTaskDto addtaskdto = new addTaskDto();
        addtaskdto.setName(name);;
        addtaskdto.setDescription(description);
        taskservice.addtask(addtaskdto);
        return "redirect:/Tasks/view";
    }

    @GetMapping("/view")
    public String viewTask(Model model) {
    
        List<viewTaskDto> allTasks =  taskservice.view();
        model.addAttribute("events", allTasks);
        return "index";

    }
    // @GetMapping("/edit/{id}")
    // public String editTask(@PathVariable(value="id")int id,Model model){
    //     updateTaskDto editingTask = taskservice.edittask(id);
    //     model.addAttribute("task", editingTask);
    //     return "editTask";
    // }
    // @PutMapping("/edit/{id}")
    // public String editTask(@PathVariable(value = "id")int id) {
    //     updateTaskDto updatetaskdto = new updateTaskDto();
    //     taskservice.edittask(updatetaskdto);
    //     return (response)?"updated":"the id doesn't exsists";
    // }

    @GetMapping("/delete/{id}")
    public String deleteTask(@PathVariable(value = "id")int id){
        taskservice.deletetask(id);
        return "redirect:/Tasks/view";
    }

    //compelete the task by id:
    @GetMapping("/complete/{id}")
    public String completeTask(@PathVariable(value="id")int id){
        taskservice.completetask(id);
        return "redirect:/Tasks/view";
    }

    @GetMapping("/complete/view")
    public String viewCompleted(Model model){
        List<viewCompletedTaskDto> cEvents = taskservice.viewcompleted();
        model.addAttribute("cEvents", cEvents);
        return "completedTasks";
    }

    @GetMapping("complete/undo/{id}")
    public String undoCompletedTask(@PathVariable(value = "id")int id){
        taskservice.undo(id);
        return "redirect:/Tasks/view";
    }


    //complete the task by dto
    // @PostMapping("/complete")
    // public String completeTask(@RequestBody completeTaskDto compltetaskdto) {
    //     taskservice.completetask(compltetaskdto);
    //     return "completed";
    // }
    
    
    
}
