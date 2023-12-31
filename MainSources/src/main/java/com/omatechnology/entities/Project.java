package com.omatechnology.entities;

public class Project {

    private String id;
    private String name;
    private String manager;
    private String client;
    private String releaseDate;
    private String description;
    private String status;

    public Project(String name, String manager, String client, String releaseDate, String description, String status) {
        this.setName(name);
        this.setManager(manager);
        this.setClient(client);
        this.setReleaseDate(releaseDate);
        this.setDescription(description);
        this.setStatus(status);

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