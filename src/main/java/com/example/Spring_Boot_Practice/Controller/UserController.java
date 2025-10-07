package com.example.Spring_Boot_Practice.Controller;

import com.example.Spring_Boot_Practice.Repository.UserRepository;
import com.example.Spring_Boot_Practice.model.UserEntity;
//import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/details/{id}")
    public UserEntity details(@PathVariable long id){
        return userRepository.findById(id).orElse(null);
    }

    @PostMapping("/createUser")
    public UserEntity createUser(@RequestBody UserEntity user){
        return userRepository.save(user);
    }

    @PutMapping("/updateUser/{id}")
    public UserEntity updateUser(@PathVariable Long id, @RequestBody UserEntity userDetails) {
        UserEntity existingUser = userRepository.findById(id).orElse(null);

        if (existingUser == null) {
            return null;
        }

        existingUser.setName(userDetails.getName());
        existingUser.setAge(userDetails.getAge());

        return userRepository.save(existingUser);
    }

    @PatchMapping("/updateOne/{id}")
    public UserEntity updateOne(@PathVariable long id , @RequestBody UserEntity user){
        UserEntity User = userRepository.findById(id).orElse(null);

        if(User == null) return null;

        if(user.getName() != null){
            User.setName(user.getName());
        }

        if (user.getAge() != 0){
            User.setAge(user.getAge());
        }

        return userRepository.save(User);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable long id){
        userRepository.deleteById(id);
    }
}


