package com.omatechnology.dataaccess;

import com.omatechnology.entities.Project;

import java.util.List;

public interface ProjectDAOInterface {
    void insert(Project project);
    Project getProjectByID(String id);
    //List<Task> getTasksByProjectID(int id);
    void updateProjectByID(Project project, String id);
    void deleteProjectByID(String id);

    List<Project> getProjectsByUsername(String username);
}
