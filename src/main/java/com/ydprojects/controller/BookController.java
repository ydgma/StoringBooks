package com.ydprojects.controller;

import com.ydprojects.dao.BookDAOImpl;
import com.ydprojects.entity.book.UTF8;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class BookController {

    @Autowired
    private BookDAOImpl bookDAO;

    @RequestMapping("/")
    public ModelAndView home() {
        ModelAndView mav = new ModelAndView("index");

        UTF8 utf8 = (UTF8) bookDAO.getBook(1L, UTF8.class);

        mav.addObject("message",utf8.getBookName());
        return mav;
    }
}
