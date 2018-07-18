package com.omatechnology.entities;

public class Task {

    private String id;
    private String name;
    private int projectID;
    private String dueDate;
    private String status;

    public Task(String name, int projectID, String dueDate, String status) {
        this.name = name;
        this.projectID = projectID;
        this.dueDate = dueDate;
        this.status = status;
    }

    public Task(String name, String dueDate, String status) {
        this.name = name;
        this.dueDate = dueDate;
        this.status = status;
    }

    public Task(String id, String name, String dueDate, String status) {
        this.id = id;
        this.name = name;
        this.dueDate = dueDate;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getProjectID() {
        return projectID;
    }

    public void setProjectID(int projectID) {
        this.projectID = projectID;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


}