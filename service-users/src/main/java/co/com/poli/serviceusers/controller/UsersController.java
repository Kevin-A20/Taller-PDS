package co.com.poli.serviceusers.controller;

import co.com.poli.servicemovies.model.Response;
import co.com.poli.serviceusers.entities.Users;
import co.com.poli.serviceusers.helper.ResponseBuilder;
import co.com.poli.serviceusers.service.UsersService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UsersController {

    private final UsersService usersService;
    private final ResponseBuilder builder;

    @PostMapping
    public Response save(@Valid @RequestBody Users users, BindingResult result){
        if(result.hasErrors()){
            return builder.failed(formatMessage(result));
        }
        usersService.save(users);
        return builder.success(users);
    }

    @DeleteMapping("/{id}")
    public Response delete(@PathVariable("id") Long id){
        Users users = usersService.findById(id);
        if(users==null){
            return builder.failed("Not found product");
        }
        usersService.delete(users);
        return builder.success(users);
    }

    @GetMapping
    public Response findAll(){
        List<Users> users = usersService.findAll();
        if(users.isEmpty()){
            return builder.failed("Users is empty");
        }
        return builder.success(users);
    }
    @GetMapping("/{id}")
    public Response findById(@PathVariable("id") Long id){
        Users users = usersService.findById(id);
        if(users==null){
            return builder.failed("Not found users");
        }
        return builder.success(users);
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
