package com.example.Spring_Boot_Practice.Model;

public class UserModel { // -> User will be a Model
    private String name; // -> fields : name


//    -------------------------------------------------------------------------
//    |      Getters and setters allow Spring Boot or other classes to access |
//    |      and modify these fields safely.                                  |                                                         |
//    |                                                                       |
//    -------------------------------------------------------------------------
    public String getName(){ // -> getter method
        return name;
    }

    public void setName(String name){
        this.name = name;
    }
}
