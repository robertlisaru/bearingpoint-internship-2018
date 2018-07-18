package com.omatechnology.dataaccess;

import com.omatechnology.entities.User;

public interface UserDAOInterface {
    void insert(User user);

    User getUserByUsername(String username);
}
