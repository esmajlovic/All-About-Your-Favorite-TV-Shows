package microservice.event;

import microservice.model.Actor;
import microservice.repository.ShowRepository;
import microservice.service.ShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Component;

@Component
@EnableBinding(Changes.class)
public class ChangesHandler {

    @Autowired
    private ShowService showService;

    @StreamListener(Changes.ACTOR_CHANGES)
    public void handleActorChanges(Actor actor) {

        showService.updateActor(actor);
    }
}
