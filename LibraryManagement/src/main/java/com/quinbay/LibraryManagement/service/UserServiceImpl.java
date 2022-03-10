package com.quinbay.LibraryManagement.service;

import com.quinbay.LibraryManagement.dto.User;
import com.quinbay.LibraryManagement.entity.UserEntity;
import com.quinbay.LibraryManagement.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;


    @Override
    public List<User> getAllUsers() {
        Iterable<UserEntity> userEntityList = userRepository.findAll();
        List<User> userResponseList = new ArrayList<>();

        for (UserEntity userEntity : userEntityList) {
            User user = new User(userEntity.getId(), userEntity.getName(), userEntity.getAddress(), userEntity.getPhoneNumber());
            userResponseList.add(user);
        }

        return userResponseList;


    }


    @Override
    public void addUser(User user){

        UserEntity userEntity = new UserEntity(user.getId(),user.getName(),user.getAddress(),user.getPhoneNumber());

        userRepository.save(userEntity);

    }



}