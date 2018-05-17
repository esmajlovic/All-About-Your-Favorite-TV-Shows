package microservice.processor;

import java.util.List;
import java.util.stream.Collectors;

import microservice.model.Actor;
import microservice.client.ActorClient;
import microservice.model.Show;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.ResourceProcessor;
import org.springframework.stereotype.Component;


@Component
public class ShowProcessor implements ResourceProcessor<Resource<? extends Show>> {

    @Autowired
    ActorClient actorClient;

    @Override
    public Resource<Show> process(Resource<? extends Show> resource) {

        Show show = resource.getContent();

        List<Actor> actors = show.getActors().stream().map(actorClient::loadActorInfo).collect(Collectors.toList());

        return new Resource<>(new Show(show, actors), resource.getLinks());
    }
}
