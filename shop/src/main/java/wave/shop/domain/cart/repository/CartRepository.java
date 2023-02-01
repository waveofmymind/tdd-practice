package wave.shop.domain.cart.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import wave.shop.domain.Cart;

public interface CartRepository extends JpaRepository<Cart, Integer> {}
