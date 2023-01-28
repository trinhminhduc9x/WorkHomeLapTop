package register.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCustomer;
    private String nameCustomer;
    private String dateOfBirthCustomer;
    private Integer genderCustomer;
    private String idCardCustomer;
    private String phoneNumberCustomer;
    private String emailCustomer;
    private String addressCustomer;


    private boolean starusDeleteCustomer;




}
