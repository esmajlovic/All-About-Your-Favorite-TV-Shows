package microservice.repository;

import microservice.model.Actor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ActorRepository extends CrudRepository<Actor, String> {
}
