package microservice.service;

import microservice.model.Actor;
import microservice.model.Show;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

@Service
public class ShowService {

    @Autowired
    private MongoTemplate mongoTemplate;

    public void updateActor(Actor actor) {
        mongoTemplate.updateMulti(
            new Query(Criteria.where("actorsId.id").is(actor.getId())),
            new Update().set("actorsId.$.name", actor.getName()), Show.class
        );
    }
}
