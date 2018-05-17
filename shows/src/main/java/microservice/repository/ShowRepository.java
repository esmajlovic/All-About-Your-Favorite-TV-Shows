package microservice.repository;

import microservice.model.Show;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


@RepositoryRestResource
public interface ShowRepository extends CrudRepository<Show, String> {
}
