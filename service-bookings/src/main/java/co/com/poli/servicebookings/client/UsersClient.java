package co.com.poli.servicebookings.client;

import co.com.poli.servicebookings.model.Response;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="service-users")
public interface UsersClient {

    @GetMapping("/store/v1/users/{id}")
    Response findById(@PathVariable("id") Long id);
}
