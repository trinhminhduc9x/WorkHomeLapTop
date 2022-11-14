package com.example.hokhau.controller;

import com.example.hokhau.repository.IKieuThanhVienRepository;
import com.example.hokhau.service.IKieuThanhVienService;
import com.example.hokhau.service.ISoHoKhauService;
import com.example.hokhau.service.IThanhVienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
@RequestMapping(value = "/thanhVien")
public class ThanhVienController {
    @Autowired
    private ISoHoKhauService iSoHoKhauService;

    @Autowired
    private IThanhVienService iThanhVienService;

    @Autowired
    private IKieuThanhVienService iKieuThanhVienService;

    @GetMapping(value = "/list")
    public String viewList(Model model,
                           @PageableDefault(6) Pageable pageable,
                           @RequestParam Optional<String> name,
                           @RequestParam(required = false, defaultValue = "") Integer kieu_thanh_vien,
                           @RequestParam(required = false, defaultValue = "") Integer so_ho_khau) {
        for (Sort.Order order : pageable.getSort()) {
            model.addAttribute("sortValue", order.getProperty());
        }

        String soHoKhauName = null;
        for (int i = 0; i < this.iSoHoKhauService.findListAll().size(); i++) {
            if ( this.iSoHoKhauService.findListAll().get(i).getId()== so_ho_khau){
                soHoKhauName = this.iSoHoKhauService.findListAll().get(i).getName();
            }
        }
        String kieuThanhVienName = null;
        for (int i = 0; i < this.iKieuThanhVienService.findListAll().size(); i++) {
            if ( this.iKieuThanhVienService.findListAll().get(i).getId()== kieu_thanh_vien){
                kieuThanhVienName = this.iKieuThanhVienService.findListAll().get(i).getName();
            }
        }

        String keyName = name.orElse("");
        model.addAttribute("soHoKhauList", this.iSoHoKhauService.findListAll());
        model.addAttribute("kieuThanhVienList", this.iKieuThanhVienService.findListAll());
        model.addAttribute("thanhVienList", this.iThanhVienService.findAllByNameAndAndThanhVienAndSoHoKhau(pageable,keyName,kieu_thanh_vien,so_ho_khau));
        model.addAttribute("keyName", keyName);
        model.addAttribute("kieuThanhVienName", kieuThanhVienName);
        model.addAttribute("soHoKhauName", soHoKhauName);

        return "thanhVien/list";

    }
}
