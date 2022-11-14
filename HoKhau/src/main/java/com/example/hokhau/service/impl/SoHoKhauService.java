package com.example.hokhau.service.impl;


import com.example.hokhau.model.SoHoKhau;
import com.example.hokhau.repository.ISoHoKhauRepository;
import com.example.hokhau.service.ISoHoKhauService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SoHoKhauService implements ISoHoKhauService {


    @Autowired
    private ISoHoKhauRepository iSoHoKhauRepository;

    @Override
    public List<SoHoKhau> findListAll() {
        return iSoHoKhauRepository.findAll();
    }

    @Override
    public List<SoHoKhau> findListById(Integer id) {
        return null;
    }

    @Override
    public void save(SoHoKhau soHoKhau) {

    }

    @Override
    public SoHoKhau findById(Integer id) {
        return null;
    }

    @Override
    public void update(SoHoKhau soHoKhau) {

    }

    @Override
    public void remove(Integer id) {

    }

    @Override
    public Page<SoHoKhau> findPageNameAll(Pageable pageable, String name) {
        return null;
    }

    @Override
    public Page<SoHoKhau> findAllByNameAndAddressAndThanh_vien(Pageable pageable, String name, String kieu_thanh_vien, Integer thanh_vien) {
        return null;
    }


}
