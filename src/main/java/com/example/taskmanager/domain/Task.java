package com.example.taskmanager.domain;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Task {

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

    @OneToMany(cascade = {CascadeType.ALL})
    @MapKeyColumn(name = "subtask")
    private List<SubTask> subTasks;

    public Task( String title, String details, LocalDateTime date) {

        this.title = title;
        this.details = details;
        this.date = date;
        subTasks = new ArrayList<>();
    }

    public Task() {

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

    public void addSubTask(SubTask subTask){
        subTasks.add(subTask);
    }
    public List<SubTask> getSubTasks(){
        return subTasks;
    }

}