package co.com.poli.servicemovies.controller;

import co.com.poli.servicemovies.entities.Movies;
import co.com.poli.servicemovies.helper.ResponseBuilder;
import co.com.poli.servicemovies.model.Response;
import co.com.poli.servicemovies.service.MoviesService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/movies")
@RequiredArgsConstructor
public class MoviesController {

    private final MoviesService moviesService;
    private final ResponseBuilder builder;

    @PostMapping
    public Response save(@Valid @RequestBody Movies movies, BindingResult result){
        if(result.hasErrors()){
           return builder.failed(this.formatMessage(result));
        }
        moviesService.save(movies);
        return builder.success(movies);
    }
    @DeleteMapping("/{title}")
    public Response delete(@PathVariable("title") String numberID){
        Movies movies = (Movies) findBytitle(numberID).getData();
        if(movies ==null){
            return builder.failed("Not found");
        }
        return builder.success(movies);
    }

    @GetMapping
    public Response findAll(){
        return builder.success(moviesService.findAll());
    }

    @GetMapping("/title/{title}")
    public Response findBytitle(@PathVariable("title") String title){
        return builder.success(moviesService.findBytitle(title));
    }

    @GetMapping("/{id}")
    public Response findByID(@PathVariable("id") Long id){
        return builder.success(moviesService.findById(id));
    }

    private  List<Map<String,String>> formatMessage(BindingResult result){
        List<Map<String,String>> errors = result.getFieldErrors().stream()
                .map(err -> {
                    Map<String,String> error = new HashMap<>();
                    error.put(err.getField(),err.getDefaultMessage());
                    return error;
                }).collect(Collectors.toList());
        return errors;
    }
}
