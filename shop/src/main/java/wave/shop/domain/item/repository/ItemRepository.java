package wave.shop.domain.item.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import wave.shop.domain.item.domain.Item;


public interface ItemRepository extends JpaRepository<Item,Long> {
}
