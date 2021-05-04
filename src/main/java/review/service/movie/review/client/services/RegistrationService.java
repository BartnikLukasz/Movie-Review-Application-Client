package review.service.movie.review.client.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import review.service.movie.review.client.models.RegistrationRequest;
import review.service.movie.review.client.models.User;
import review.service.movie.review.client.services.MovieReviewUserDetailsService;

@Service
public class RegistrationService {

    @Autowired
    private MovieReviewUserDetailsService userDetailsService;

    public String register(RegistrationRequest request) {
        return userDetailsService.signUpUser(new User(request.getUsername(), request.getPassword()));
    }
}
