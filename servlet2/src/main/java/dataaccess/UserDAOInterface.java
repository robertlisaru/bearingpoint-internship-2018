package dataaccess;

import com.omatechnology.entities.User;

public interface UserDAOInterface {
    void insert(User user);
    boolean verifyUserLogin(User user);
}
