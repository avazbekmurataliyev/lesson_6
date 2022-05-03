package uz.avazbek.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uz.avazbek.springboot.model.Passport;
import uz.avazbek.springboot.repository.PassportRepository;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class MainController {

    @Autowired
    private PassportRepository passportRepository;

    @RequestMapping(value = "/users",method = RequestMethod.POST)
    public String saveUser(@RequestBody Passport passport){
        try {
         passportRepository.save(passport);
         return "Saved";
        }catch (Exception e){
            return "This passport id use already";
        }


    }
    @GetMapping("/users")
    public List<Passport> getUsers(){
        return passportRepository.findAll();
    }


}
