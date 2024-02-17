package org.example.springboot.DAO;

import org.example.springboot.model.User;
import java.util.List;

public interface UserDao {
    void saveUser(User user);
    User findUserById(Long id);
    void updateUser(User user);
    void deleteUser(User user);
    List<User> getAllUsers();

}
