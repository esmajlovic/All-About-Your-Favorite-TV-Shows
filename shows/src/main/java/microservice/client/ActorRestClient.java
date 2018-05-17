package microservice.client;

import microservice.model.Actor;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("actors")
public interface ActorRestClient {

    @RequestMapping(method = RequestMethod.GET, value = "/actors/{id}")
    Actor get(@PathVariable("id") String id);
}