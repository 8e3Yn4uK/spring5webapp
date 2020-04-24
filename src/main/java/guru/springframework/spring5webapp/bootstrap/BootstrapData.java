package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.domain.Publisher;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import guru.springframework.spring5webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * Created by 8e3Yn4uK on 24.04.2020.
 */
@Component
public class BootstrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootstrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        System.out.println("Started bootstrap");

        Publisher publisher = new Publisher("SFG Publishing", "7574", "Kyiv", "Ukraine", "01001");
        publisherRepository.save(publisher);

        System.out.println("Publisher count " + publisherRepository.count());

        Author dan = new Author("Dan", "Brown");
        Book b1 = new Book("Angesl & Deamons", "99888556412");
        dan.getBooks().add(b1);
        b1.getAuthors().add(dan);

        b1.setPublisher(publisher);
        publisher.getBooks().add(b1);

        authorRepository.save(dan);
        bookRepository.save(b1);
        publisherRepository.save(publisher);

        Author lina = new Author("Lina", "Kostenko");
        Book b2 = new Book("Kryla", "45678912354");
        lina.getBooks().add(b2);
        b2.getAuthors().add(lina);

        b2.setPublisher(publisher);
        publisher.getBooks().add(b2);

        authorRepository.save(lina);
        bookRepository.save(b2);
        publisherRepository.save(publisher);


        System.out.println("Number of books: " + bookRepository.count());
        System.out.println("Number of books of publisher: " + publisher.getBooks().size());
    }
}
