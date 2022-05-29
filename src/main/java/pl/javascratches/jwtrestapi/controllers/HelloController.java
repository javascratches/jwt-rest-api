package pl.javascratches.jwtrestapi.controllers;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.javascratches.jwtrestapi.model.HelloResponse;

@RestController
@RequestMapping("/hello")
public class HelloController {

    @GetMapping
    public HelloResponse hello(@AuthenticationPrincipal User user) {
        return new HelloResponse("Hello " + user.getUsername());
    }
}
