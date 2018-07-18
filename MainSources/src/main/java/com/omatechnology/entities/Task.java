package com.omatechnology.entities;

public class Task {
    private String name;
    private int projectID;
    private String estimatedDate;
    private String status;

    public Task(String name, int projectID, String estimatedDate, String status) {
        this.name = name;
        this.projectID = projectID;
        this.estimatedDate = estimatedDate;
        this.status = status;
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

    public String getEstimatedDate() {
        return estimatedDate;
    }

    public void setEstimatedDate(String estimatedDate) {
        this.estimatedDate = estimatedDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}