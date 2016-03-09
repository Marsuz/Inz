package core.controllers;

import core.model.Response;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by Marcin on 2016-03-09.
 */

@RestController
public class BaseController {

    AtomicInteger responseCounter = new AtomicInteger(0);

    @RequestMapping("/hello")
    @ResponseBody
    String home() {

        String helloMessage = "Hello! </br>";
        return helloMessage;
    }

    @RequestMapping("/")
    @ResponseBody
    Response response() {

        Response response = new Response(responseCounter.getAndIncrement(), "Response number" + responseCounter.intValue());
        return response;

    }


}
