package com.example.hokhau.controller;

import com.example.hokhau.repository.IKieuThanhVienRepository;
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
@RequestMapping(value = "/hoKhau")
public class HoKhauController {
    @Autowired
    private ISoHoKhauService iSoHoKhauService;

    @Autowired
    private IThanhVienService iThanhVienService;

    @Autowired
    private IKieuThanhVienRepository iKieuThanhVienRepository;

    @GetMapping(value = "/list")
    public String viewList(Model model,
                           @PageableDefault(6) Pageable pageable,
                           @RequestParam Optional<String> name,
                           @RequestParam(required = false, defaultValue = "") String address,
                           @RequestParam(required = false, defaultValue = "") Integer thanh_vien) {
        for (Sort.Order order : pageable.getSort()) {
            model.addAttribute("sortValue", order.getProperty());
        }

        String thanhVienName = null;
        for (int i = 0; i < this.iThanhVienService.findListAll().size(); i++) {
            if ( this.iThanhVienService.findListAll().get(i).getId()== thanh_vien){
                thanhVienName = this.iThanhVienService.findListAll().get(i).getName();
            }
        }

        String keyName = name.orElse("");
        model.addAttribute("soHoKhauList", this.iSoHoKhauService.findAllByNameAndAddressAndThanh_vien(pageable,keyName,address,thanh_vien));
        model.addAttribute("thanhVienList", this.iThanhVienService.findListAll());
        model.addAttribute("keyName", keyName);
        model.addAttribute("address", address);
        model.addAttribute("thanhVienName", thanhVienName);

        return "hoKhau/list";

    }

}
