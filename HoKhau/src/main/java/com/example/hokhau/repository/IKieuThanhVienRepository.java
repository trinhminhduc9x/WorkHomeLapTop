package com.example.hokhau.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.hokhau.model.KieuThanhVien;
import org.springframework.stereotype.Service;

@Service
public interface IKieuThanhVienRepository extends JpaRepository<KieuThanhVien, Integer> {

}
