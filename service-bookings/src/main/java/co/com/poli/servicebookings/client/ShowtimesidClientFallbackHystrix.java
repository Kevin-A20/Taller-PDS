package co.com.poli.servicebookings.client;

import co.com.poli.servicebookings.helper.ResponseBuilder;
import co.com.poli.servicebookings.model.Movies;
import co.com.poli.servicebookings.model.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ShowtimesidClientFallbackHystrix implements ShowtimesidClient {

    private final ResponseBuilder builder;

    @Override
    public Response findByname(String name) {
        return builder.success(new Movies());
    }

    @Override
    public Response findByID(Long id) {
        return builder.success(new Movies());
    }
}
