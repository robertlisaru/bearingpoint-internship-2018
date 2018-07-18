package com.omatechnology.dataaccess;

import com.omatechnology.entities.Task;

import java.util.List;

public interface TaskDAOInterface {
    void insert(Task task);

    List<Task> getTasksByProjectId(String id);


}
