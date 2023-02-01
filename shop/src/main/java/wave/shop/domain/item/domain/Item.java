package wave.shop.domain.item.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Builder
public class Item {

    @Id
    @GeneratedValue
    @Column(name= "item_id")
    private Long id;
    @Column(name="item_name",unique = true)
    private String itemName;

    private String itemDetail;
    private int price; // 상품 가격

    private int count; // 판매 개수
    private int stock; // 재고

    private boolean status; // 상품 상태 (판매중 / 품절)
}
