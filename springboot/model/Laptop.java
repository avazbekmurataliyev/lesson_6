package uz.avazbek.springboot.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Laptop {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;

    @Column(nullable = false)
    private String name ;

    @Column(nullable = false)
    private String brandName ;

    @Column(nullable = false)
    private String model ;

    @Column(nullable = false)
    private String ram ;

    @Column(nullable = false)
    private Integer storage ;

    @Column(nullable = false, unique = true)
    private String macAddress ;


}
