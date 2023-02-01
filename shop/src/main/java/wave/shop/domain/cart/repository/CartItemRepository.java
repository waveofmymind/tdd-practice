package wave.shop.domain.cart.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import wave.shop.domain.cart.domain.CartItem;

public interface CartItemRepository extends JpaRepository<CartItem,Long> {
}
