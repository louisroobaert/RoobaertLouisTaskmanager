package com.example.taskmanager.repository;

import com.example.taskmanager.domain.SubTask;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubTaskRepository extends JpaRepository<SubTask,Integer> {
}
