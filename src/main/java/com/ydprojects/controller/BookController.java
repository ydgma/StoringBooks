package com.ydprojects.controller;

import com.ydprojects.dao.BookDAOImpl;
import com.ydprojects.entity.book.BookImpl;
import com.ydprojects.entity.book.PDF;
import com.ydprojects.entity.book.UTF8;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

@Controller
public class BookController {

    @Autowired
    private BookDAOImpl bookDAO;

    @RequestMapping("/")
    public ModelAndView home() {
        ModelAndView mav = new ModelAndView("index");

        UTF8 utf8 = (UTF8) bookDAO.getBook(1L, UTF8.class);

        //test method
        mav.addObject("message","work in progress");
        mav.addObject("bookname",utf8.getBookName());
        return mav;
    }

    @RequestMapping("/addBook")
    public String newBook(Map<String,Object> model){
        model.put("book", new BookImpl());
        model.put("message1","work in progress");
        return "add_book";
    }
}
