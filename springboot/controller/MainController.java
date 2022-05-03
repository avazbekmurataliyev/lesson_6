package uz.avazbek.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uz.avazbek.springboot.model.Phone;
import uz.avazbek.springboot.repository.PhoneRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/admin")
public class MainController {

    @Autowired
    private PhoneRepository phoneRepository;

    @RequestMapping(value = "/users",method = RequestMethod.POST)
    public String saveUser(@RequestBody Phone phone){
        try {
         phoneRepository.save(phone);
         return "Saved";
        }catch (Exception e){
            return "This mac address is use already";
        }


    }
    @RequestMapping(value = "/users" ,method = RequestMethod.GET)
    public List<Phone> getUsers(){
        return phoneRepository.findAll();
    }

    @RequestMapping(value = "/users/{id}" ,method = RequestMethod.GET)
    public Phone getUsers(@PathVariable Long id){
        Optional<Phone> phone = phoneRepository.findById(id);
        if (phone.isPresent()){
            return phone.get();
        }
        else {
            return new Phone();
        }
    }
    @RequestMapping(value = "/users/{id}" ,method = RequestMethod.DELETE)
    public String deletePhone(@PathVariable Long id){
        if (phoneRepository.findById(id).isPresent()){
            phoneRepository.delete(phoneRepository.getById(id));
            return "Deleted phone info";
        }

        return "Error";
    }


    @RequestMapping(value = "/users/{id}" ,method = RequestMethod.PUT)
    public String updatePhone(@PathVariable Long id,@RequestBody Phone phone){
        Optional<Phone> phone1 = phoneRepository.findById(id);
        if (phone1.isPresent()){
            Phone phone2 = phone1.get();
            phone2.setName(phone.getName());
            phone2.setModel(phone.getModel());
            phone2.setMacAddress(phone.getMacAddress());
            phone2.setInfo(phone.getInfo());
            phoneRepository.save(phone2);
            return "Updated";
        }
    else {
    return "Error update";
        }

    }


}
