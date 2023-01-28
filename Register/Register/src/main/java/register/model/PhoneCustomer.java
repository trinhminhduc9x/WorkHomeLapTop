package register.model;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class PhoneCustomer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPhoneCustomer;

    private String phoneNumberCustomer;


}
