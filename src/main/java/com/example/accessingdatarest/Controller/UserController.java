package com.example.accessingdatarest.Controller;

import com.example.accessingdatarest.Model.Response;
import com.example.accessingdatarest.Model.User;
import com.example.accessingdatarest.Repositories.UserRepository;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller // This means that this class is a Controller
@RequestMapping(path="/user") // This means URL's start with /demo (after Application path)
public class UserController {
    @Autowired // This means to get the bean called userRepository
    // Which is auto-generated by Spring, we will use it to handle the data
    private UserRepository userRepository;

    @PostMapping(path="/regUser") // Map ONLY POST Requests
    public @ResponseBody String addNewUser (@RequestBody User user) {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request
        try {
            User n = new User();
            n.setName(user.getName());
            n.setPhone_number(user.getPhone_number());
            n.setPassword(user.getPassword());
            n.setPackage_id(1);
            n.setCount(0);
            n.setRole_id("User");
            userRepository.save(n);
            return "Saved";
        }
        catch (Exception ex)
        {
            return "Phone already exist!";
        }
    }
    @PostMapping(path="/regAdmin") // Map ONLY POST Requests
    public @ResponseBody String regAdmin (@RequestBody User user) {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request
        try {
            User n = new User();
            n.setName(user.getName());
            n.setPhone_number(user.getPhone_number());
            n.setPassword(user.getPassword());
            n.setPackage_id(user.getPackage_id());
            n.setCount(user.getCount());
            n.setRole_id("Admin");
            userRepository.save(n);
            return "Saved";
        }
        catch (Exception ex)
        {
            return "Phone already exist!";
        }
    }
    @PostMapping(path="/authorize") // Map ONLY POST Requests
    public @ResponseBody String authorize (@RequestBody User user) {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request
        try {

          Iterable<User> allUsers=  userRepository.findAll();
            for (User element : allUsers)
            {
                if (element.getPhone_number().equals(user.getPhone_number()) && element.getPassword().equals(user.getPassword())) {
                   // return element.getRole_id();
                   return new Gson().toJson(new Response(element.getId(),element.getRole_id(),element.getPackage_id(),element.getName()));
                }

            }
            return "Not authorized";
        }
        catch (Exception ex)
        {
            return ex.toString();
        }
    }
    @PostMapping(path="/delete") // Map ONLY POST Requests
    public @ResponseBody String deleteUser (@RequestParam int id) {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request


        userRepository.deleteById(id);
        return "User deleted !";
    }
    @PostMapping(path="/updateUser") // Map ONLY POST Requests
    public @ResponseBody String updateUser (@RequestParam int id,@RequestParam String name , @RequestParam String phone_number) {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request

        User item=userRepository.findById(id).get();
        item.setName(name);
        item.setPhone_number(phone_number);
        userRepository.save(item);

        return "User updated !";
    }
    @PostMapping(path="/updatePhone") // Map ONLY POST Requests
    public @ResponseBody String updateEmail (@RequestParam int id,@RequestParam String phone_number) {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request

        User item=userRepository.findById(id).get();
        item.setPhone_number(phone_number);
        userRepository.save(item);
        return "User phone_number updated !";
    }


    @GetMapping(path="/all")
    public @ResponseBody Iterable<User> getAllUsers() {
        // This returns a JSON or XML with the users
        return userRepository.findAll();
    }
}