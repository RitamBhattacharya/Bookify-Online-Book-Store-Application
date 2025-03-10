package com.ritam.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.ritam.entity.Book;
import com.ritam.entity.MyBookList;
import com.ritam.service.BookServiceImpl;
import com.ritam.service.MyBookListServiceImpl;

@Controller
public class BookController {

    @Autowired
    private BookServiceImpl service;

    @Autowired
    private MyBookListServiceImpl myBookService;

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("currentPage", "home");
        return "home";
    }

    @GetMapping("/book_register")
    public String bookRegister(Model model) {
        return "bookRegister";
    }

    @GetMapping("/available_books")
    public ModelAndView getAllBook() {
        List<Book> list = service.getAllBooks();
        ModelAndView modelAndView = new ModelAndView("bookList");
        modelAndView.addObject("book", list);
        modelAndView.addObject("currentPage", "available_books");
        return modelAndView;
    }

    @PostMapping("/save")
    public String addBook(@ModelAttribute Book b) {
        service.saveBook(b);
        return "redirect:/available_books";
    }

    @GetMapping("/my_books")
    public String getMyBooks(Model model) {
        List<MyBookList> list = myBookService.getAllMyBooks();
        model.addAttribute("book", list);
        model.addAttribute("currentPage", "my_books");
        return "myBooks";
    }

    @GetMapping("/mylist/{id}")
    public String getMyList(@PathVariable int id) {
        Book b = service.getBookById(id);
        MyBookList mb = new MyBookList(b.getId(), b.getName(), b.getAuthor(), b.getPrice());
        myBookService.saveMyBooks(mb);
        return "redirect:/my_books";
    }

    @GetMapping("/editBook/{id}")
    public String editBook(@PathVariable int id, Model model) {
        Book b = service.getBookById(id);
        model.addAttribute("book", b);
        return "bookEdit";
    }

    @GetMapping("/deleteBook/{id}")
    public String deleteBook(@PathVariable int id) {
        service.deleteById(id);
        return "redirect:/available_books";
    }

    @GetMapping("/deleteMyList/{id}")
    public String deleteMyList(@PathVariable int id) {
        myBookService.deleteById(id);
        return "redirect:/my_books";
    }
}
