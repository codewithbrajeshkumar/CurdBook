package com.curdoperation.Controller;

import com.curdoperation.Entity.Book;
import com.curdoperation.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book/v1")
public class BookController {

    @Autowired
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping("/addBook")
    public ResponseEntity<Book> addBook(@RequestBody Book book) {
        Book saveBook = bookService.addBook(book);
        return ResponseEntity.ok(saveBook);
    }

    @GetMapping("/getAllBooks")
    public ResponseEntity<List<Book>> getAllBook() {
        List<Book> allBooks = bookService.getAllBooks();
        return ResponseEntity.ok(allBooks);
    }


    @GetMapping("/getBook/{bookName}")
    public ResponseEntity<Book> getBookByName(@PathVariable("bookName") String name){
        final Book bookByName = bookService.getBookByName(name);
        return ResponseEntity.ok(bookByName);
    }

    @PutMapping("/updateBook")
    public ResponseEntity<Book> updateBook(@RequestBody Book book){
        Book updateBook = bookService.updateBook(book);
        return ResponseEntity.ok(updateBook);
    }

    @DeleteMapping("/deleteBook/{id}")
    public ResponseEntity<Object> deleteBook(@PathVariable ("id") Integer integer){
         bookService.deleteById(integer);
         return ResponseEntity.ok().build();

    }

}
