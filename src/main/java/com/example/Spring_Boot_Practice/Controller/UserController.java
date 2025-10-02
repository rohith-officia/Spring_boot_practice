package com.example.Spring_Boot_Practice.Controller;

import com.example.Spring_Boot_Practice.Repository.UserRepository;
import com.example.Spring_Boot_Practice.model.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/createUser")
    public UserEntity createUser(@RequestBody UserEntity user){
        return userRepository.save(user);
    }

//    @PostMapping("/createUser1")
//    public HashMap<String , String> createUser1(@RequestBody UserEntity user){
//        userRepository.save(user);
//        HashMap<String , String> map = new HashMap<>();
//        map.put("Name" , user.getName());
//        map.put("Age" , user.getAge()+"");
//        return map;
//    }



}
