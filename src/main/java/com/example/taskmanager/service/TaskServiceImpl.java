package com.example.taskmanager.service;

import com.example.taskmanager.domain.SubTask;
import com.example.taskmanager.domain.Task;
import com.example.taskmanager.dto.TaskDTO;
import com.example.taskmanager.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Louis Roobaert
 * @version 1.0 27/02/2020 10:54
 */
@Service
public class TaskServiceImpl implements TaskService {
    private final TaskRepository repository;

    @Autowired
    public TaskServiceImpl(TaskRepository repository) {
        this.repository = repository;
        this.addTask(new TaskDTO("Task1","Yeeeet",LocalDateTime.of(2020,3,25,15,00)));
        this.addTask(new TaskDTO("Task2","REEEET",LocalDateTime.of(2020,3,27,12,30)));
    }

    @Override
    public List<TaskDTO> getTasks() {
        return repository.findAll().stream().map(h -> {
            TaskDTO dto = new TaskDTO();
            dto.setDate(h.getDate());
            dto.setDetails(h.getDetails());
            dto.setTitle(h.getTitle());
            dto.setId(h.getId());
            return dto;
        }).collect(Collectors.toList());
    }


    @Override
    public Task getTask(int id) {
        return repository.getOne(id);
    }


    @Override
    public void addTask(TaskDTO taskDTO) {
        Task task = new Task(taskDTO.getTitle(), taskDTO.getDetails(), taskDTO.getDate());
        repository.save(task);

    }

    @Override
    public void editTask(Task task) {
        repository.save(task);
    }

    @Override
    public void addSubTask(SubTask subTask) {
        Task task = repository.getOne(subTask.getIDTask());
        task.addSubTask(subTask);
        repository.save(task);

    }


}
