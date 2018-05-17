package microservice.event;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface Changes {

    @Output("actorChanges")
    MessageChannel actorChanges();

}
