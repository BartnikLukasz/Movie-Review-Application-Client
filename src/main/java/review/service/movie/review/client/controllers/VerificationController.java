package review.service.movie.review.client.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import review.service.movie.review.client.models.RegistrationRequest;
import review.service.movie.review.client.services.MovieReviewUserDetailsService;
import review.service.movie.review.client.services.RegistrationService;


@RestController
@RequestMapping(path = "/r")
public class VerificationController {

    @Autowired
    private RegistrationService registrationService;

    @Autowired
    private MovieReviewUserDetailsService userDetailsService;


    @PostMapping("/register")
    public String register(@RequestBody RegistrationRequest request){
        return registrationService.register(request);
    }

}
