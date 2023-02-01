package wave.shop.domain.item.application;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import wave.shop.domain.item.domain.Item;
import wave.shop.domain.item.dto.ItemRequestDto;
import wave.shop.domain.item.dto.ItemUpdateDto;
import wave.shop.domain.item.repository.ItemRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ItemService {

    private final ItemRepository itemRepository;

    public void saveItem(ItemRequestDto requestDto) {
        Item item = requestDto.toEntity();
        itemRepository.save(item);
    }

    public Item findOne(Long itemId) {
        return itemRepository.findById(itemId).orElseThrow(EntityNotFoundException::new);
    }

    public List<Item> findAll() {
        return itemRepository.findAll();
    }

    public void updateItem(ItemUpdateDto updateDto, Long itemId) {
        Item findItem = itemRepository.findById(itemId).get();
        findItem.setItemName(updateDto.itemName());
        findItem.setPrice(updateDto.price());
        findItem.setItemDetail(updateDto.itemDetail());
        findItem.setStock(updateDto.stock());
    }

    public void delete(Long itemId) {
        itemRepository.deleteById(itemId);
    }
}
