package review.service.movie.review.client.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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


    @CrossOrigin
    @PostMapping("/register")
    public String register(@RequestBody RegistrationRequest request){
        return registrationService.register(request);
    }


}
