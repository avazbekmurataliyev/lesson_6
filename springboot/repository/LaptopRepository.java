package uz.avazbek.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.avazbek.springboot.model.Laptop;

public interface LaptopRepository extends JpaRepository<Laptop,Long> {


}
