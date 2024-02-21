package br.com.willbigas.book;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

	private final BookRepository bookRepository;

	public BookController(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}

	@GetMapping
	public List<Book> getAll() {
		return bookRepository.findAll();
	}

	@PostMapping
	public Book create(@RequestBody Book book) {
		return bookRepository.save(book);
	}

	@GetMapping("/{id}")
	public Book getById(@PathVariable Long id) {
		return bookRepository.findById(id).orElse(null);
	}
}
