package guru.springframework.spring5webapp.repositories;

import guru.springframework.spring5webapp.domain.Book;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by 8e3Yn4uK on 24.04.2020.
 */

public interface BookRepository extends CrudRepository<Book, Long> {
}
