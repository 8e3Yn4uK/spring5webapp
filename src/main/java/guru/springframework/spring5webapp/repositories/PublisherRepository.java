package guru.springframework.spring5webapp.repositories;

import guru.springframework.spring5webapp.domain.Publisher;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by 8e3Yn4uK on 24.04.2020.
 */

public interface PublisherRepository extends CrudRepository<Publisher, Long> {
}
