package com.validation.validationExample.service;

import com.validation.validationExample.dto.UserRequest;
import com.validation.validationExample.entity.User;
import com.validation.validationExample.exception.UserNotFoundException;
import com.validation.validationExample.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    //save new user
    public User saveUser(UserRequest userRequest){
        User user = User.build(0,
                userRequest.getUserName(),
                userRequest.getEmail(),
                userRequest.getDateOfBirth(),
                userRequest.getMobile());
        return userRepository.save(user);
    }
    //get all user
    public List<User> getAllUser(){
        return userRepository.findAll();
    }

    //get user by id
    public User getUserByID(int userId) throws UserNotFoundException {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException("User not found with id: " + userId));
        return user;
    }

    //update user info
    public void updateUser(int id, UserRequest userRequest){
        User user = userRepository.findByUserId(id);
        user.setUserName(userRequest.getUserName());
        user.setEmail(userRequest.getEmail());
        user.setDateOfBirth(userRequest.getDateOfBirth());
        user.setMobile(userRequest.getMobile());
        userRepository.save(user);
    }

    //delete user by id
    public void deleteUser(int id){
        userRepository.deleteById(id);
    }
}
