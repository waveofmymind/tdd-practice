package wave.shop.domain.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import wave.shop.domain.user.domain.User;


public interface UserRepository extends JpaRepository<User, Integer> {
    User findByUsername(String username);
}