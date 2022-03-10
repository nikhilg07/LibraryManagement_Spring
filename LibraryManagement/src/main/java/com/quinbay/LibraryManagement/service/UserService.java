//    API to add a new user
package com.quinbay.LibraryManagement.service;


import com.quinbay.LibraryManagement.dto.User;

import java.util.List;

public interface UserService {

    List<User>getAllUsers();
    void addUser(User user);

}

