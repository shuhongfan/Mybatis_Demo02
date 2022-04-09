package com.itheima.controller;

import com.itheima.domain.Book;
import com.itheima.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BookController {
    @Autowired
    private BookService bookService;

    @RequestMapping("/book")
    public ModelAndView findBookById(Integer id) {
        Book book = bookService.findBookById(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("book.jsp");
        modelAndView.addObject("book", book);
        return modelAndView;
    }
}

