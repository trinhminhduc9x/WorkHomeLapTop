package projectbackend.model.customer;
import javax.persistence.*;

@Entity
public class PhoneCustomer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPhoneCustomer;
    private String phoneNumberCustomer;

    @ManyToOne
    @JoinColumn(name = "id_Customer",referencedColumnName = "idCustomer")
    private Customer customer;



    public PhoneCustomer() {
    }

    public PhoneCustomer(Integer idPhoneCustomer, String phoneNumberCustomer, Customer customer) {
        this.idPhoneCustomer = idPhoneCustomer;
        this.phoneNumberCustomer = phoneNumberCustomer;
        this.customer = customer;
    }

    public Integer getIdPhoneCustomer() {
        return idPhoneCustomer;
    }

    public void setIdPhoneCustomer(Integer idPhoneCustomer) {
        this.idPhoneCustomer = idPhoneCustomer;
    }

    public String getPhoneNumberCustomer() {
        return phoneNumberCustomer;
    }

    public void setPhoneNumberCustomer(String phoneNumberCustomer) {
        this.phoneNumberCustomer = phoneNumberCustomer;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
