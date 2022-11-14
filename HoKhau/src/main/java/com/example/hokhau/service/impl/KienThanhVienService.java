package com.example.hokhau.service.impl;

import com.example.hokhau.model.KieuThanhVien;
import com.example.hokhau.model.SoHoKhau;
import com.example.hokhau.repository.IKieuThanhVienRepository;
import com.example.hokhau.service.IKieuThanhVienService;
import com.example.hokhau.service.ISoHoKhauService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KienThanhVienService implements IKieuThanhVienService {


    @Autowired
    private IKieuThanhVienRepository iKieuThanhVienRepository;

    @Override
    public List<KieuThanhVien> findListAll() {
        return iKieuThanhVienRepository.findAll();
    }

    @Override
    public List<KieuThanhVien> findListById(Integer id) {
        return null;
    }

    @Override
    public void save(KieuThanhVien kieuThanhVien) {

    }

    @Override
    public KieuThanhVien findById(Integer id) {
        return null;
    }

    @Override
    public void update(KieuThanhVien kieuThanhVien) {

    }

    @Override
    public void remove(Integer id) {

    }

    @Override
    public Page<KieuThanhVien> findPageNameAll(Pageable pageable, String name) {
        return null;
    }
}
