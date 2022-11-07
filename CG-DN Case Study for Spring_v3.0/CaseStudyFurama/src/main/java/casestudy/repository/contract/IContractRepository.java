package casestudy.repository.contract;

import casestudy.model.contract.Contract;
import casestudy.model.customer.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IContractRepository extends JpaRepository<Contract,Integer> {

}
