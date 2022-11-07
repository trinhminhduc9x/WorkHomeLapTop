package casestudy.service.impl.contract;

import casestudy.model.contract.ContractDetail;
import casestudy.service.contract.IContracDetailService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public class ContractDetailService implements IContracDetailService {

    @Override
    public List<ContractDetail> findListAll() {
        return null;
    }

    @Override
    public List<ContractDetail> findListById(Integer id) {
        return null;
    }

    @Override
    public void save(ContractDetail contractDetail) {

    }

    @Override
    public ContractDetail findById(Integer id) {
        return null;
    }

    @Override
    public void update(ContractDetail contractDetail) {

    }

    @Override
    public void remove(Integer id) {

    }

    @Override
    public Page<ContractDetail> findPageNameAll(Pageable pageable, String name) {
        return null;
    }
}
