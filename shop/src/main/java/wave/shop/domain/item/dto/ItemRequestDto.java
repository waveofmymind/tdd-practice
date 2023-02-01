package wave.shop.domain.item.dto;

import wave.shop.domain.item.domain.Item;

public record ItemRequestDto(String itemName,
                             String itemDetail,
                             int price,// 상품 가격
                             int count, // 판매 개수
                             int stock // 재고
) {

    public Item toEntity()
    {
        return Item.builder()
                .itemName(itemName)
                .itemDetail(itemDetail)
                .price(price)
                .count(count)
                .stock(stock)
                .build();
    }
}
