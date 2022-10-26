package com.example.controller;

import com.example.model.Book;
import com.example.model.OrderacsAndPayacs;
import com.example.service.IBookService;
import com.example.service.IOandPservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;


@Controller
@RequestMapping("/book")
public class BookController {

    @Autowired
    private IBookService bookService;


    @Autowired
    private IOandPservice oandPservice;


    @GetMapping("/list")
    public String goPage(Model model,
                         @PageableDefault(6) Pageable pageable,
                         @RequestParam Optional<String> name) {
        for (Sort.Order order : pageable.getSort()) {
            model.addAttribute("sortValue", order.getProperty());
        }
        String keyName = name.orElse("");
        Page<Book> bookPage = bookService.findPageAll(pageable, keyName);


        List<Book> bookList = bookService.findListAll();


        model.addAttribute("bookPage", bookList);
        model.addAttribute("name", keyName);
        return "book/list";
    }

    @GetMapping("/create")
    public String create(Model model) {

        List<OrderacsAndPayacs> orderacsAndPayacsList = oandPservice.findListAll();


        model.addAttribute("orderacsAndPayacsList", orderacsAndPayacsList);


        model.addAttribute("book", new Book());


        return "/book/create";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Book book) {

        bookService.save(book);

        return "redirect:/book/list";
    }


    @GetMapping("/{id}/oder")
    public String edit(@PathVariable int id, Model model) {


        Book book = bookService.findById(id);

        OrderacsAndPayacs orderacsAndPayacs = oandPservice.findById(id);


        Integer oder = book.getAmount() - 1;

        orderacsAndPayacs.setOrderasc(oder);

        oandPservice.save(orderacsAndPayacs);

        System.out.printf(orderacsAndPayacs.toString());


//        model.addAttribute("book", bookService.findById(id));
////        model.addAttribute("categoryList", categoryService.findAll());
        return "/book/list";
    }


//
//    @GetMapping("/{id}/edit")
//    public String edit(@PathVariable int id, Model model) {
//        model.addAttribute("blog", blogService.findById(id));
//        model.addAttribute("categoryList", categoryService.findAll());
//        return "/blog/edit";
//    }
//
//    @PostMapping("/update")
//    public String update(Blog blog) {
//        blogService.update(blog);
//        return "redirect:/blog/list";
//    }
//
//    @GetMapping("/delete")
//    public String delete(@RequestParam(name = "id") Integer id) {
//        blogService.remove(id);
//        return "redirect:/blog/list";
//    }
//
//
//
//    @GetMapping("/search")
//    public String search(@RequestParam int id, Model model) {
//        model.addAttribute("products", blogService.findById(id));
//        return "/blog/index";
//    }
//
//    @GetMapping("/pay")
//    public String goPay() {
//        return "pay";
//    }
//    @PostMapping("/pay")
//    public String pay(Model model,
//                      @PageableDefault(6) Pageable pageable,
//                      @RequestParam Optional<String> name,
//                      @RequestParam(required = false, defaultValue = "") String note
//    ) throws Exception {
//        String keyName = name.orElse("");
//        Page<Blog> blogPage = blogService.findAll(pageable,keyName, note);
//        if (blogPage == null) {
//            System.out.println("Hello");
//
//
//            System.out.println("Aaaa");
//
//            throw new Exception();
//        }
//        return "redirect:/blog/list";
//    }
//
//    @ExceptionHandler(value = Exception.class)
//    public String error() {
//        return "error";
//    }


}