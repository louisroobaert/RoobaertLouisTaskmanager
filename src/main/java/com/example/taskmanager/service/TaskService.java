package com.example.taskmanager.service;

import com.example.taskmanager.domain.SubTask;
import com.example.taskmanager.domain.Task;
import com.example.taskmanager.dto.TaskDTO;

import java.util.List;

/**
 * @author Louis Roobaert
 * @version 1.0 27/02/2020 10:52
 */
public interface TaskService {
    List<TaskDTO> getTasks();
    Task getTask(int id);
    void addTask(TaskDTO taskDTO);
    void editTask(Task task);
    void addSubTask(SubTask subTask);
}
