package co.com.poli.servicebookings.client;

import co.com.poli.servicebookings.model.Response;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "service-showtimes", fallback = ShowtimesidClientFallbackHystrix.class)
public interface ShowtimesidClient {

    @GetMapping("/store/v1/movies/name/{name}")
    Response findByname(@PathVariable("name") String name);

    @GetMapping("/store/v1/movies/{id}")
    Response findByID(@PathVariable("id") Long id);

}
