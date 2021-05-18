package review.service.movie.review.client.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import review.service.movie.review.client.util.UserRepository;
import review.service.movie.review.client.models.MovieReviewUserDetails;
import review.service.movie.review.client.models.User;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class MovieReviewUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findByUsername(userName);

        user.orElseThrow(() -> new UsernameNotFoundException("Not found: " + userName));

        return new MovieReviewUserDetails(user.get());
    }

    public ArrayList<User> getAllUsers(){
        return userRepository.findAll();
    }

    public String signUpUser(User user){
        boolean exists = userRepository.findByUsername(user.getUsername()).isPresent();
        if(exists){
            return "Username taken." + user.getUsername();
        }

        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));

        userRepository.save(user);

        return "works";
    }

}
