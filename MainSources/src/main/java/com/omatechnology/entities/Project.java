package com.omatechnology.entities;

public class Project {

    private String projectName;
    private String manager;
    private String client;
    private String releaseDate;
    private String description;
    private String status;


    public Project(String projectName, String manager, String client, String releaseDate, String description, String status) {
        this.setProjectName(projectName);
        this.setManager(manager);
        this.setClient(client);
        this.setReleaseDate(releaseDate);
        this.setDescription(description);
        this.setStatus(status);

    }

    public String getName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}