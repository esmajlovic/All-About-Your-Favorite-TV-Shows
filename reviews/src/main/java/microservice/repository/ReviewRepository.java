package microservice.repository;

import microservice.model.Review;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;


@RepositoryRestResource
public interface ReviewRepository extends CrudRepository<Review, Long> {

    @RestResource(path = "by-show")
    Page findByShowId(@Param("showId") String showId, Pageable p);
}
