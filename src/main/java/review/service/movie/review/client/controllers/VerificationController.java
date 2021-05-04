package review.service.movie.review.client.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import review.service.movie.review.client.models.RegistrationRequest;
import review.service.movie.review.client.services.MovieReviewUserDetailsService;
import review.service.movie.review.client.services.RegistrationService;


@RestController
@RequestMapping(path = "/")
public class VerificationController {

    @Autowired
    private RegistrationService registrationService;

    @Autowired
    private MovieReviewUserDetailsService userDetailsService;

    @GetMapping("/home")
    public String home(){
        return ("<h1>Welcome</h1>");
    }

    @GetMapping("/user")
    public String user(){
        return ("<h1>Welcome user</h1>");
    }

    @GetMapping("/admin")
    public String admin(){
        return ("<h1>Welcome admin</h1>");
    }

    @PostMapping("/register")
    public String register(@RequestBody RegistrationRequest request){
        return registrationService.register(request);
    }

}
