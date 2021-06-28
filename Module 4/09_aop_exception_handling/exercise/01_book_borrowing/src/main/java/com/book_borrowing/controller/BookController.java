package com.book_borrowing.controller;

import com.book_borrowing.exception.InvalidBorrowCodeException;
import com.book_borrowing.exception.OutOfBookException;
import com.book_borrowing.model.entity.Book;
import com.book_borrowing.model.entity.BorrowCode;
import com.book_borrowing.model.service.IBookService;
import com.book_borrowing.model.service.IBorrowCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class BookController {
    @Autowired
    private IBookService bookService;
    @Autowired
    private IBorrowCodeService borrowCodeService;

    @GetMapping(value = "/")
    public String index() {
        return "index";
    }

    @GetMapping(value = "/book-list")
    public ModelAndView showListBook() {
        return new ModelAndView("book-list", "bookList", bookService.findAll());
    }

    @GetMapping(value = "/create-book")
    public String showCreateBookForm(Model model) {
        model.addAttribute("book", new Book());
        return "create-book";
    }

    @PostMapping(value = "/create-book/create")
    public String createBook(@ModelAttribute("book") Book book, RedirectAttributes redirect) {
        this.bookService.createBook(book);
        redirect.addFlashAttribute("message", "Succesfully Created The Book");
        return "redirect:/";
    }

    @GetMapping(value = "/borrow-book")
    public String showBookDetail(@RequestParam(value = "id") int id, Model model) {
        model.addAttribute("book", this.bookService.findById(id));
        return "book-detail";
    }

    @GetMapping(value = "/borrowed-book-list")
    public String showBorrowedBookList(Model model) {
        model.addAttribute("borrowedList", this.borrowCodeService.findAll());
        return "borrowed-book-list";
    }

    @PostMapping(value = "/borrow-book/borrow")
    public String borrowBook(@ModelAttribute("book") Book book, Model model) throws Exception {
        if (book.getQuantity() == 0) {
            throw new OutOfBookException();
        }
        Integer quantity = book.getQuantity() - 1;
        book.setQuantity(quantity);
        this.bookService.updateBook(book);
        Long codeId = Math.round(Math.random() * 10000);
        this.borrowCodeService.create(new BorrowCode(codeId, book));
        model.addAttribute("codeId", codeId);
        return "index";
    }

    @GetMapping(value = "/return-book")
    public String showReturnBookForm() {
        return "return-book";
    }

    @PostMapping(value = "/return-book/return")
    public String returnBook(@RequestParam("id") Long id, Model model) throws InvalidBorrowCodeException {
        BorrowCode borrowCode = this.borrowCodeService.findById(id);
        if (borrowCode == null) {
            throw new InvalidBorrowCodeException();
        }
        this.borrowCodeService.deleteById(id);
        Book book = this.bookService.findById(borrowCode.getBook().getId());
        book.setQuantity(book.getQuantity() + 1);
        this.bookService.updateBook(book);
        model.addAttribute("message", "Successfully return the Book!");
        return "index";
    }


    @ExceptionHandler(OutOfBookException.class)
    public String showOutOfBookError() {
        return "out-of-book-error";
    }

    @ExceptionHandler(InvalidBorrowCodeException.class)
    public String showInvalidBorrowCodeError() {
        return "ivalid-code-error";
    }
}
