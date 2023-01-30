package projectbackend.repository.customer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import projectbackend.model.customer.PhoneCustomer;

@Repository
@Transactional
public interface IIphoneCustomerRepository extends JpaRepository<PhoneCustomer,Integer> {

}
