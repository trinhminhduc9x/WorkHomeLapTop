package com.example.hokhau.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class ThanhVien {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Integer id;

    private String name;

    private String birthday;

    private String identifyCard;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "kieuThanhVien", referencedColumnName = "id")
    private KieuThanhVien kieuThanhVien;


    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "soHoKhau", referencedColumnName = "id")
    private SoHoKhau soHoKhau;


}
