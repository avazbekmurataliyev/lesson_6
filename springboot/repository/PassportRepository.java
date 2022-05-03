package uz.avazbek.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.avazbek.springboot.model.Passport;

public interface PassportRepository extends JpaRepository<Passport,Long> {


}
