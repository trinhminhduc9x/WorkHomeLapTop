package com.example.hokhau.repository;



import com.example.hokhau.model.ThanhVien;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IThanhVienRepository extends JpaRepository<ThanhVien, Integer> {
    @Query(value = " select *  from thanh_vien where name like %:name% and kieu_thanh_vien like %:kieu_thanh_vien% and so_ho_khau like %:so_ho_khau%", nativeQuery = true)
    Page<ThanhVien> findAllByNameAndAndThanhVienAndSoHoKhau(Pageable pageable, @Param("name") String name, @Param("kieu_thanh_vien") Integer kieu_thanh_vien, @Param("so_ho_khau") Integer so_ho_khau);

}
