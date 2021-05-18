package review.service.movie.review.client.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;
import review.service.movie.review.client.models.User;
import review.service.movie.review.client.services.MovieReviewUserDetailsService;

import java.util.ArrayList;

@RestController
@RequestMapping(path = "/")
@CrossOrigin("*")
public class ClientController {

    @Autowired
    private MovieReviewUserDetailsService userDetailsService;

    @GetMapping("/home")
    public RedirectView localRedirect() {
        RedirectView redirectView = new RedirectView();
        redirectView.setUrl("http://www.yahoo.com");
        return redirectView;
    }

    @GetMapping("/users")
    public ArrayList<User> users(){
        return userDetailsService.getAllUsers();
    }

    @GetMapping("/user")
    public String user(){
        return ("<h1>Welcome user</h1>");
    }

    @GetMapping("/admin")
    public String admin(){
        return ("<h1>Welcome admin</h1>");
    }

}
