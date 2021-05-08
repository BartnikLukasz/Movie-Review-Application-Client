package review.service.movie.review.client.util;

import org.springframework.data.jpa.repository.JpaRepository;
import review.service.movie.review.client.models.User;

import java.util.ArrayList;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByUsername(String userName);
    ArrayList<User> findAll();
}
