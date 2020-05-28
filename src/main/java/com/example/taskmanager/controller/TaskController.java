package com.example.taskmanager.controller;

import com.example.taskmanager.domain.SubTask;
import com.example.taskmanager.domain.Task;
import com.example.taskmanager.dto.TaskDTO;
import com.example.taskmanager.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @author Louis Roobaert
 * @version 1.0 27/02/2020 10:49
 */

@Controller
@RequestMapping("/task")
public class TaskController {
    private final TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService) { this.taskService = taskService; }

   @GetMapping
    public String getTasks(Model model){
        model.addAttribute("tasks", taskService.getTasks());
        return "tasks";
    }



    @GetMapping(value = "id", params = {"id"})
    public String getTaskDetails(Model model, @RequestParam(value = "id") int id){
        model.addAttribute("task", taskService.getTask(id));
        return "taskDetails";
    }


    @GetMapping(value = "/edit/id", params = {"id"})
    public String edit(Model model,  @RequestParam(value = "id") int id){
        model.addAttribute("task", taskService.getTask(id));
        return "taskEdit";
    }

    @PostMapping("/edit")
    public String postEdit(@ModelAttribute @Valid Task task , BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "form";
        }
        taskService.editTask(task);
        return "redirect:/task";
    }

    @GetMapping("/new")
    public String getCreateForm(Model model){
        model.addAttribute("task", new TaskDTO());
        return "form";
    }

    @PostMapping("/new")
    public String postNewTask(@ModelAttribute @Valid TaskDTO taskDTO, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "form";
        }
        taskService.addTask(taskDTO);
        return "redirect:/task";
    }

    @GetMapping(value = "/sub/create/id", params = {"id"})
    public String getCreateSubTaskForm(Model model, @RequestParam(value = "id") int id){
        model.addAttribute("subtask", new SubTask(id));
        return "subTaskForm";
    }


    @PostMapping("/new/subtask")
    public String postNewSubTask(Model model,@ModelAttribute @Valid SubTask subTask, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "subTaskForm";
        }
        taskService.addSubTask(subTask);
        model.addAttribute("task", taskService.getTask(subTask.getIDTask()));
        return "taskDetails";
    }

}
