package projectbackend.model.customer;

import projectbackend.model.account.Account;

import javax.persistence.*;

@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCustomer;
    private String nameCustomer;
    private String dateOfBirthCustomer;
    private Integer genderCustomer;
    private String idCardCustomer;
    private String emailCustomer;
    private String addressCustomer;

    private boolean starusDeleteCustomer;


    @OneToOne
    @JoinColumn(name = "accountname", referencedColumnName = "accountname")
    private Account account;


    public Customer() {
    }

    public Customer(Integer idCustomer, String nameCustomer, String dateOfBirthCustomer, Integer genderCustomer, String idCardCustomer, String emailCustomer, String addressCustomer, boolean starusDeleteCustomer, PhoneCustomer phoneCustomer, Account account) {
        this.idCustomer = idCustomer;
        this.nameCustomer = nameCustomer;
        this.dateOfBirthCustomer = dateOfBirthCustomer;
        this.genderCustomer = genderCustomer;
        this.idCardCustomer = idCardCustomer;
        this.emailCustomer = emailCustomer;
        this.addressCustomer = addressCustomer;
        this.starusDeleteCustomer = starusDeleteCustomer;
        this.account = account;
    }

    public Integer getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(Integer idCustomer) {
        this.idCustomer = idCustomer;
    }

    public String getNameCustomer() {
        return nameCustomer;
    }

    public void setNameCustomer(String nameCustomer) {
        this.nameCustomer = nameCustomer;
    }

    public String getDateOfBirthCustomer() {
        return dateOfBirthCustomer;
    }

    public void setDateOfBirthCustomer(String dateOfBirthCustomer) {
        this.dateOfBirthCustomer = dateOfBirthCustomer;
    }

    public Integer getGenderCustomer() {
        return genderCustomer;
    }

    public void setGenderCustomer(Integer genderCustomer) {
        this.genderCustomer = genderCustomer;
    }

    public String getIdCardCustomer() {
        return idCardCustomer;
    }

    public void setIdCardCustomer(String idCardCustomer) {
        this.idCardCustomer = idCardCustomer;
    }

    public String getEmailCustomer() {
        return emailCustomer;
    }

    public void setEmailCustomer(String emailCustomer) {
        this.emailCustomer = emailCustomer;
    }

    public String getAddressCustomer() {
        return addressCustomer;
    }

    public void setAddressCustomer(String addressCustomer) {
        this.addressCustomer = addressCustomer;
    }

    public boolean isStarusDeleteCustomer() {
        return starusDeleteCustomer;
    }

    public void setStarusDeleteCustomer(boolean starusDeleteCustomer) {
        this.starusDeleteCustomer = starusDeleteCustomer;
    }


    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
