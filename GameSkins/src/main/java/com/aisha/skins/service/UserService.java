package com.aisha.skins.service;
import java.util.List;

import com.aisha.skins.entities.User;

public interface UserService {
    List <User> findAll();
    
    User saveUser(User u);
    User updateUser(User u);
    void deleteUser(User u);
     void deleteUserById(Long id);
     User getUser(Long idUser);

}
