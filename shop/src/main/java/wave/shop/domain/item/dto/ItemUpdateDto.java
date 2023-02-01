package wave.shop.domain.item.dto;

import wave.shop.domain.item.domain.Item;

public record ItemUpdateDto(String itemName,
                            String itemDetail,
                            int price,
                            int count,
                            int stock) {

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
