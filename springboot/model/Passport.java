package uz.avazbek.springboot.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Passport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;

    @Column(nullable = false)
    private String name ;

    @Column(nullable = false)
    private String surname ;
    @Column(nullable = false)
    private Date brithDate ;
    @Column(nullable = false)
    private Date issuedDate ;
    @Column(nullable = false, unique = true)
    private String passport_id ;

    @Column(nullable = false)
    private String country ;

    @Column(nullable = false)
    private String region ;


}
