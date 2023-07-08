package com.example.accessingdatarest.Controller;

import com.example.accessingdatarest.Model.Hystory;
import com.example.accessingdatarest.Model.Package;
import com.example.accessingdatarest.Model.User;
import com.example.accessingdatarest.Repositories.HystoryRepository;
import com.example.accessingdatarest.Repositories.PackageRepository;
import com.example.accessingdatarest.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@Controller // This means that this class is a Controller
@RequestMapping(path="/package") // This means URL's start with /demo (after Application path)
public class PackageController {
    @Autowired // This means to get the bean called userRepository
    // Which is auto-generated by Spring, we will use it to handle the data
    private UserRepository userRepository;
    @Autowired // This means to get the bean called userRepository
    // Which is auto-generated by Spring, we will use it to handle the data
    private PackageRepository packageRepository;
    @Autowired // This means to get the bean called userRepository
    // Which is auto-generated by Spring, we will use it to handle the data
    private HystoryRepository hystoryRepository;

    @PostMapping(path = "/addPackage") // Map ONLY POST Requests
    public @ResponseBody String addPackage(@RequestParam String role,@RequestParam String name,int max) {

        if(role.equals("Admin"))
        {
            try {
                Package _package = new Package();
                _package.setName(name);
                _package.setMax(max);
                packageRepository.save(_package);
                return "Saved";
            }
            catch (Exception ex)
            {
                return "Package already exist!";
            }
        }
        return "Error by permit";
    }
    @PostMapping(path = "/updateNamePackage") // Map ONLY POST Requests
    public @ResponseBody String updateNamePackage(@RequestParam String role,@RequestParam int id,@RequestParam String name) {

        if(role=="Admin")
        {

                if(packageRepository.existsById(id))
                {
                    Package _package = packageRepository.findById(id).get();
                    _package.setName(name);
                packageRepository.save(_package);
                return "Saved";
            }
            else
            {
                return "Package already exist!";
            }
        }
        return "Error by permit";
    }
    @PostMapping(path = "/updateMaxPackage") // Map ONLY POST Requests
    public @ResponseBody String updateMaxPackage(@RequestParam String role,@RequestParam int id,@RequestParam int max) {

        if(role=="Admin")
        {

            if(packageRepository.existsById(id))
            {
                Package _package = packageRepository.findById(id).get();
                _package.setMax(max);
                packageRepository.save(_package);
                return "Saved";
            }
            else
            {
                return "Error!";
            }
        }
        return "Error by permit";
    }
    @PostMapping(path = "/updatePricePackage") // Map ONLY POST Requests
    public @ResponseBody String updatePricePackage(@RequestParam String role,@RequestParam int id,@RequestParam int price) {

        if(role=="Admin")
        {

            if(packageRepository.existsById(id))
            {
                Package _package = packageRepository.findById(id).get();
                _package.setPrice(price);
                packageRepository.save(_package);
                return "Saved";
            }
            else
            {
                return "Error!";
            }
        }
        return "Error by permit";
    }

    @PostMapping(path = "/buyPackage") // Map ONLY POST Requests
    public @ResponseBody String buyPackage(@RequestParam int user_id,@RequestParam int package_id) {



            if(userRepository.existsById(user_id) && packageRepository.existsById(package_id))
            {
                User user=userRepository.findById(user_id).get();
                user.setPackage_id(packageRepository.findById(package_id).get().getId());
                Hystory item=new Hystory(  LocalDateTime.now()
                    .format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS")),user_id,packageRepository.findById(package_id).get().getName());
                userRepository.save(user);
                hystoryRepository.save(item);
                return "You buy:  " + packageRepository.findById(package_id).get().getName();
            }
            else
            {
                return "Error!";
            }

    }

    @GetMapping(path="/all")
    public @ResponseBody Iterable<Package> getAllUsers() {
        // This returns a JSON or XML with the users
        return packageRepository.findAll();
    }
}