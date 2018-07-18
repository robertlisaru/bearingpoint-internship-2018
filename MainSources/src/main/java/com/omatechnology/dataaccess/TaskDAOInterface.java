package com.omatechnology.dataaccess;

import com.omatechnology.entities.Task;

import java.util.List;

public interface TaskDAOInterface {
    void insert(Task task);

    Task getTaskByID(String id);

    void updateTask(Task task);

    void deleteTaskByID(String id);

    List<Task> getTasksByProjectId(String id);


}
