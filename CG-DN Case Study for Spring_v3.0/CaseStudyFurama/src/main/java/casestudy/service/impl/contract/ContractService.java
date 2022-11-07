package casestudy.service.impl.contract;

import casestudy.model.contract.Contract;
import casestudy.service.contract.IContractService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public class ContractService implements IContractService {
    @Override
    public List<Contract> findListAll() {
        return null;
    }

    @Override
    public List<Contract> findListById(Integer id) {
        return null;
    }

    @Override
    public void save(Contract contract) {

    }

    @Override
    public Contract findById(Integer id) {
        return null;
    }

    @Override
    public void update(Contract contract) {

    }

    @Override
    public void remove(Integer id) {

    }

    @Override
    public Page<Contract> findPageNameAll(Pageable pageable, String name) {
        return null;
    }
}
