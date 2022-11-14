package com.example.hokhau.service;

import com.example.hokhau.model.KieuThanhVien;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IKieuThanhVienService extends IGeneralService<KieuThanhVien>{

    @Override
    List<KieuThanhVien> findListAll();

    @Override
    List<KieuThanhVien> findListById(Integer id);

    @Override
    void save(KieuThanhVien kieuThanhVien);

    @Override
    KieuThanhVien findById(Integer id);

    @Override
    void update(KieuThanhVien kieuThanhVien);

    @Override
    void remove(Integer id);

    @Override
    Page<KieuThanhVien> findPageNameAll(Pageable pageable, String name);
}
