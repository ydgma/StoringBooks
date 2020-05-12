package com.ydprojects.controller;

import com.ydprojects.dao.BookDAOImpl;
import com.ydprojects.entity.book.BookImpl;
import com.ydprojects.entity.book.BookType;
import com.ydprojects.entity.book.PDF;
import com.ydprojects.entity.book.UTF8;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

@Controller
public class BookController {

    @Autowired
    private BookDAOImpl bookDAO;

    @RequestMapping("/")
    public ModelAndView home() {
        ModelAndView mav = new ModelAndView("Index");
        //test method
        //mav.addObject("message","work in progress");
        return mav;
    }

    @RequestMapping("/savePDF")
    public String newPDF(Map<String,Object> model){
        model.put("PDF", new BookImpl());
        return "PDF";
    }

    @RequestMapping("/saveUTF8")
    public String newUTF8(Map<String,Object> model){
        model.put("UTF8", new BookImpl());
        return "UTF8";
    }

    @RequestMapping(value = "/savePDF", method = RequestMethod.POST)
    public String savePDF(@ModelAttribute("PDF") PDF book) {
        PDF pdf = new PDF(book.getBookName(),book.getFilePath());
        bookDAO.addBook(pdf);
        return "redirect:/";
    }

    @RequestMapping(value = "/saveUTF8", method = RequestMethod.POST)
    public String saveUTF8(@ModelAttribute("UTF8") UTF8 book) {
        UTF8 utf8 = new UTF8(book.getBookName(),book.getFilePath());
        bookDAO.addBook(utf8);
        return "redirect:/";
    }

}
