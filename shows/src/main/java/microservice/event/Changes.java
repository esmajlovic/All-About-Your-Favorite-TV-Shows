package microservice.event;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

public interface Changes {

    String ACTOR_CHANGES = "actorChanges";

    @Input(ACTOR_CHANGES)
    SubscribableChannel actorChanges();

}
