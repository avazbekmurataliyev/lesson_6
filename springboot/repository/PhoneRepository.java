package uz.avazbek.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.avazbek.springboot.model.Phone;

public interface PhoneRepository extends JpaRepository<Phone,Long> {


}
