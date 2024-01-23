package com.example.Library.Management.controller;
import com.example.Library.Management.model.Book;
import com.example.Library.Management.model.User;
import com.example.Library.Management.repository.BookRepository;
import com.example.Library.Management.service.BookService;
import com.example.Library.Management.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller

//@RequestMapping("/app/library")
public class BookController {

    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private BookService bookService;

    /**
     * Admin Homepage
     * @param model
     * @return
     */

    @GetMapping("/admin/home")
    public String home(Model model){return "homepage";}

    /**
     * User Homepage
     * @param model
     * @return
     */

    @GetMapping("/user/home")
    public String homeUser(Model model){return "homepageUser";}

    /**
     * Show list of books Admin
     * @param model
     * @return
     */

    @GetMapping("/admin/list-books")
    public String getAllBooks(Model model) {
        List<Book> books=bookService.findAll();
        model.addAttribute("book",books);
        return "fetchBook";
    }

    /**
     * Show list of books User
     * @param model
     * @return
     */

    @GetMapping("/user/list-books")
    public String getAllBooksUser(Model model) {
        List<Book> books=bookService.findAll();
        model.addAttribute("book",books);
        return "fetchBookUser";
    }

    /**
     * Add new book
     * @param model
     * @return
     */

    @GetMapping("/admin/add")
    public String addBookUrl(Model model) {
//        List<User> users=userService.getAllUsers();
        Book book = new Book();
        model.addAttribute("book", book);
//        model.addAttribute("users",users);
//        model.addAttribute("user", new User()); // Add an empty User object to resolve the binding error
        return "newBook";
    }

    /**
     *
     * @param book
     * @return
     */
//
//    @PostMapping("/admin/addBook")
//    public String addBook(@ModelAttribute("book") Book book, @RequestParam("selectedUserId") Long selectedUserId) {
////        User user = userService.findById(selectedUserId); // Retrieve the User based on the selected user's ID
////        book.setUser(user); // Set the User in the Book entity
//        bookService.save(book);
//        return "redirect:/admin/list-books";
//    }
    @PostMapping("/admin/addBook")
    public String addBook(@ModelAttribute("book") Book book) {
        bookService.addBook(book);
        return "redirect:/admin/list-books";
    }

    /**
     * Update the book
     * @param id
     * @param model
     * @return
     */

    @GetMapping("/admin/update/{id}")
    public String updatePage(@PathVariable("id") Long id, Model model) {
        Book book = bookRepository.findById(id).get();
//        List<User> users = userService.getAllUsers(); // Retrieve the list of users
        model.addAttribute("book", book);
//        model.addAttribute("users", users); // Add the 'users' attribute to the model
        return "updateBook";
    }

//    @PostMapping("/admin/update")
//    public String updateBook(@ModelAttribute("book") Book book) {
//        // Retrieve the book from the repository
//        Book existingBook = bookRepository.findById(book.getId()).orElse(null);
//
//        if (existingBook != null) {
//            existingBook.setTotalCopies(book.getTotalCopies());
//            existingBook.setCopiesBorrowed(book.getCopiesBorrowed());
//
//            // Save the updated book
//            bookRepository.save(existingBook);
//        }
//
//        return "redirect:/admin/list-books";
//    }
//

    /**
     *
     * @param book
     * @param selectedUserId
     * @return
     */

    @PostMapping("/admin/update")
public String updateBook(@ModelAttribute("book") Book book, @RequestParam("selectedUserId") Long selectedUserId) {
//    User user = userService.findById(selectedUserId); // Retrieve the User based on the selected user's ID
//    book.setUser(user); // Set the User in the Book entity
    bookService.update(book); // Update the book
    return "redirect:/admin/list-books";
}

    /**
     * Delete the book
     * @param id
     * @return
     */

    @RequestMapping("/admin/delete/{id}")
    public String deleteBook(@PathVariable Long id) {
        bookService.deleteById(id);
        return "redirect:/admin/list-books";
    }
}
