package wave.shop.domain.item.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import wave.shop.domain.item.application.ItemService;
import wave.shop.domain.item.domain.Item;
import wave.shop.domain.item.dto.ItemRequestDto;
import wave.shop.domain.item.dto.ItemUpdateDto;

@Controller
@RequiredArgsConstructor

public class ItemController {

    private final ItemService itemService;

    @GetMapping("/item/new")
    public String itemSaveForm() {

        return "/items/itemSaveForm";
    }

    @PostMapping("/items/new")
    public String itemSave(ItemRequestDto requestDto) {

        itemService.saveItem(requestDto);
        return "/main";
    }

    @GetMapping("/items/update/{itemId}")
    public String itemUpdateForm(@PathVariable("itemId") Long itemId, Model model) {

        model.addAttribute("item", itemService.findOne(itemId));

        return "/items/itemUpdateForm";
    }

    @PostMapping("/items/update/{itemId}")
    public String itemUpdate(@PathVariable("itemId") Long itemId, ItemUpdateDto updateDto) {
        itemService.updateItem(updateDto, itemId);

        return "redirect:/main";
    }
    @GetMapping("/item/view/{itemId}")
    public String itemView(Model model, @PathVariable("itemId") Long itemId) {

        model.addAttribute("item", itemService.findOne(itemId));

        return "/items/itemDetail";
    }

    // 상품 삭제
    @DeleteMapping("/item/delete/{itemId}")
    public String itemDelete(@PathVariable("id") Long itemId) {

        itemService.delete(itemId);

        return "/main";
    }
}
