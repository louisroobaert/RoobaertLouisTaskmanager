package com.example.taskmanager.dto;

import com.example.taskmanager.domain.SubTask;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Louis Roobaert
 * @version 1.0 27/02/2020 10:45
 */
public class TaskDTO {

    @Id
    @GeneratedValue
    private int id;

    @NotEmpty
    @Size(min = 3)
    private String title;
    @NotEmpty
    @Size(min = 3)
    private String details;
    private LocalDateTime date;


    public TaskDTO( String title, String details, LocalDateTime date) {
        this.title = title;
        this.details = details;
        this.date = date;
    }

    public TaskDTO() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
