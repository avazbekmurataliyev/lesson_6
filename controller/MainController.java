package uz.avazbek.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import uz.avazbek.springboot.model.Users;
import uz.avazbek.springboot.repository.UserRepository;

@RestController
@RequestMapping("/admin")
public class MainController {

    @Autowired
    private UserRepository userRepository;

    @RequestMapping(value = "/users",method = RequestMethod.POST)
    public String saveUser(@RequestBody Users users){
        if (users.getPhoneNumber().length()>=7) {
            userRepository.save(users);
            return "Saved";
        }
        else {
            return "Kiritilgan raqam mos emas";
        }
    }


}
