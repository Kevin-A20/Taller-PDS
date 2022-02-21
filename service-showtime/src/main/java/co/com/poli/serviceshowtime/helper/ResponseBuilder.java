package co.com.poli.serviceshowtime.helper;

import co.com.poli.serviceshowtime.model.Response;
import static org.springframework.http.HttpStatus.*;
import org.springframework.stereotype.Component;

@Component
public class ResponseBuilder {

    public Response success(){
        return Response.builder()
                .code(OK.value())
                .data(OK.value())
                .build();
    }
    public Response success(Object data){
        return Response.builder()
                .code(OK.value())
                .data(data)
                .build();
    }
    public Response failed(Object data){
        return Response.builder()
                .code(INTERNAL_SERVER_ERROR.value())
                .data(data)
                .build();
    }

}
