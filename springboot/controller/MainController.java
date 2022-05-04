package uz.avazbek.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uz.avazbek.springboot.model.Laptop;
import uz.avazbek.springboot.repository.LaptopRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/admin")
public class MainController {

    @Autowired
    private LaptopRepository laptopRepository;

    @RequestMapping(value = "/laptops",method = RequestMethod.POST)
    public String saveUser(@RequestBody Laptop laptop){
        try {
        laptopRepository.save(laptop);
         return "Saved";
        }catch (Exception e){
            return "This mac address is use already";
        }


    }
    @RequestMapping(value = "/laptops" ,method = RequestMethod.GET)
    public List<Laptop> getUsers(){
        return laptopRepository.findAll();
    }

    @RequestMapping(value = "/laptops/{id}" ,method = RequestMethod.GET)
    public Laptop getUsers(@PathVariable Long id){
        Optional<Laptop> laptop = laptopRepository.findById(id);
        if (laptop.isPresent()){
            return laptop.get();
        }
        else {
            return new Laptop();
        }
    }
    @RequestMapping(value = "/laptops/{id}" ,method = RequestMethod.DELETE)
    public String deletePhone(@PathVariable Long id){
        if (laptopRepository.findById(id).isPresent()){
            laptopRepository.delete(laptopRepository.getById(id));
            return "Deleted Laptop ";
        }

        return "Error";
    }


    @RequestMapping(value = "/laptops/{id}" ,method = RequestMethod.PUT)
    public String updatePhone(@PathVariable Long id,@RequestBody Laptop laptop){
        Optional<Laptop> laptop1 = laptopRepository.findById(id);
        if (laptop1.isPresent()){
            Laptop laptop2 = laptop1.get();
            laptop2.setName(laptop.getName());
            laptop2.setBrandName(laptop.getBrandName());
            laptop2.setRam(laptop.getRam());
            laptop2.setStorage(laptop.getStorage());
            laptop2.setModel(laptop.getModel());
            laptop2.setMacAddress(laptop.getMacAddress());
            laptopRepository.save(laptop2);
            return "Updated";
        }
    else {
    return "Error update";
        }

    }


}
