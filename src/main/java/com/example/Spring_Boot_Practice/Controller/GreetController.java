package com.example.Spring_Boot_Practice.Controller;

import com.example.Spring_Boot_Practice.model.UserEntity;
import com.example.Spring_Boot_Practice.model.UserModel;
import com.example.Spring_Boot_Practice.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class GreetController {

    @GetMapping("/greet") //http://localhost:8080/greet
    public String greet(){
        return "Hi !";
    }

    @GetMapping("/greet2")
    public String greet2(@RequestParam String name){
        return "Hi " + name + "!";
//    -------------------------------------------------------------------------
//    |      @RequestParam -> for Query parameter (?param = value)            |                                                         |
//    |      http://localhost:8080/greet2?name=zara                           |                                   |         |
//    -------------------------------------------------------------------------
    }

    @GetMapping("greet3/{name}")
    public String greet3(@PathVariable String name){
        return "Hi " + name + "!";
//    -------------------------------------------------------------------------
//    |      @PathVariable -> for path variable (/value)                       |                                                         |
//    |      http://localhost:8080/greet3/zara                                 |                                   |         |
//    -------------------------------------------------------------------------
    }

    ArrayList<UserModel> list = new ArrayList<>();

    @GetMapping("/get") // -> Getting all the user
    public ArrayList<UserModel> get(){
        return list;
    }

    @GetMapping("/getOne/{name}") // -> Getting one user
    public UserModel getOne(@PathVariable String name){
        for(UserModel user : list){
            if(user.getName().equals(name)){
                return user;
            }
        }
        return null;
    }

    @PostMapping("/create")
    public String create(@RequestBody UserModel user){
        list.add(user);
        return "Hi " + user.getName();
//    -------------------------------------------------------------------------
//    |     user.getName() -> reads the name field from the user object.      |
//    -------------------------------------------------------------------------
    }

    @PutMapping("/update/{name}")
    public String update(@PathVariable String name , @RequestBody UserModel Updatename){
        for(UserModel user : list){
            if(user.getName().equals(name)){
                user.setName(Updatename.getName());
                return user.getName();
            }
        }
        return "user not find";
//    ---------------------------------------------------------------------------------------------
//    |  user.setName(...) → updates the existing user object in memory with this new value.      |
//    ---------------------------------------------------------------------------------------------
    }

//    @DeleteMapping("/delete/{name}")
//    public void delete(@PathVariable String name){
//        list.removeIf(user -> user.getName().equals(name));
//    }

    @DeleteMapping("/deleteUser/{name}")
    public String deleteUser(@PathVariable String name) {
        for (UserModel user : list) {
            if (user.getName().equalsIgnoreCase(name)) {
                list.remove(user);
                return "User deleted successfully!";
            }
        }
        return "User not found!";
    }
}
