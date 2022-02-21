package co.com.poli.servicebookings.controller;

import co.com.poli.servicebookings.entities.Bookings;
import co.com.poli.servicebookings.helper.ResponseBuilder;
import co.com.poli.servicebookings.model.Response;
import co.com.poli.servicebookings.service.BookingsService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/bookings")
@RequiredArgsConstructor
public class BookingsController {

    private final BookingsService bookingsService;
    private final ResponseBuilder builder;

    @PostMapping()
    public Response save(@Valid @RequestBody Bookings bookings, BindingResult result){
        if(result.hasErrors()){
            return builder.failed(formatMessage(result));
        }
        bookingsService.save(bookings);
        return builder.success(bookings);
    }

    @DeleteMapping("/{id}")
    public Response delete(@PathVariable("id") String id) {
        Bookings bookings = bookingsService.findByAllBookings(id);
        if(bookings ==null){
            return builder.failed(bookings);
        }
        return builder.success(bookings);
    }

    @GetMapping("/{id}")
    public Response getById(@PathVariable("id") String id){
        Bookings bookings = bookingsService.findByAllBookings(id);
        if(bookings ==null){
            return builder.success();
        }
        return builder.success(bookings);
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
