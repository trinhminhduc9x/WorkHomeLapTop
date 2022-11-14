package com.example.hokhau.service;

import com.example.hokhau.model.SoHoKhau;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ISoHoKhauService extends IGeneralService<SoHoKhau> {

    @Override
    List<SoHoKhau> findListAll();

    @Override
    List<SoHoKhau> findListById(Integer id);

    @Override
    void save(SoHoKhau soHoKhau);

    @Override
    SoHoKhau findById(Integer id);

    @Override
    void update(SoHoKhau soHoKhau);

    @Override
    void remove(Integer id);

    @Override
    Page<SoHoKhau> findPageNameAll(Pageable pageable, String name);


    Page<SoHoKhau> findAllByNameAndAddressAndThanh_vien(Pageable pageable, String name,String kieu_thanh_vien,Integer thanh_vien);


}
