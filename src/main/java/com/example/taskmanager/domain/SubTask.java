package com.example.taskmanager.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
public class SubTask {


    @Id
    @GeneratedValue
    private int ID;


    private int IDTask;

    private String title;

    private String details;


    public SubTask(int IDTask, String title, String details) {
        setIDTask(IDTask);
        setTitle(title);
        setDetails(details);
    }

    public SubTask() {

    }

    public SubTask(int id) {
        setIDTask(id);
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getIDTask() {
        return IDTask;
    }

    public void setIDTask(int IDTask) {
        this.IDTask = IDTask;
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
}
