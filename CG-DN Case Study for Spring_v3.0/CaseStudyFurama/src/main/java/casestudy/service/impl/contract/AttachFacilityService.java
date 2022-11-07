package casestudy.service.impl.contract;

import casestudy.model.contract.AttachFacility;
import casestudy.service.contract.IAttachFacilityService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public class AttachFacilityService implements IAttachFacilityService {
    @Override
    public List<AttachFacility> findListAll() {
        return null;
    }

    @Override
    public List<AttachFacility> findListById(Integer id) {
        return null;
    }

    @Override
    public void save(AttachFacility attachFacility) {

    }

    @Override
    public AttachFacility findById(Integer id) {
        return null;
    }

    @Override
    public void update(AttachFacility attachFacility) {

    }

    @Override
    public void remove(Integer id) {

    }

    @Override
    public Page<AttachFacility> findPageNameAll(Pageable pageable, String name) {
        return null;
    }
}
