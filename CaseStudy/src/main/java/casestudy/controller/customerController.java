package casestudy.controller;

import casestudy.model.customer.Customer;
import casestudy.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/customer")
public class customerController {
    @Autowired
    private ICustomerService iCustomerService;
    @GetMapping("/list")
    public String showPage (Model model,
                            @PageableDefault(6) Pageable pageable,
                            @RequestParam(required = false, defaultValue = "") String name,
                            @RequestParam(required = false, defaultValue = "") String dataOfBirth,
                            @RequestParam(required = false, defaultValue = "") String CustomerTypeID)  {
        Page<Customer> customerPage = iCustomerService.fildPageAll(pageable,name,dataOfBirth,CustomerTypeID);
        model.addAttribute("customerPage",customerPage);
        return "customer/list";
    }
}
