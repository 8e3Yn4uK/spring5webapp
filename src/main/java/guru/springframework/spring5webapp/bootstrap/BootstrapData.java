package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * Created by 8e3Yn4uK on 24.04.2020.
 */
@Component
public class BootstrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    public BootstrapData(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Author dan = new Author("Dan", "Brown");
        Book b1 = new Book("Angesl & Deamons", "99888556412");
        dan.getBooks().add(b1);
        b1.getAuthors().add(dan);
        authorRepository.save(dan);
        bookRepository.save(b1);

        Author lina = new Author("Lina", "Kostenko");
        Book b2 = new Book("Kryla", "45678912354");
        lina.getBooks().add(b2);
        b2.getAuthors().add(lina);
        authorRepository.save(lina);
        bookRepository.save(b2);

        System.out.println("Started bootstrap");
        System.out.println("Number of books " + bookRepository.count());
    }
}
