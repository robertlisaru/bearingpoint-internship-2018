package com.omatechnology.dataaccess;

import com.omatechnology.entities.Project;

import java.util.List;

public interface ProjectDAOInterface {
    void insert(Project project);
    Project getProjectByID(String id);
    void updateProjectByID(Project project);
    void deleteProjectByID(String id);

    List<Project> getProjectsByUsername(String username);
}
