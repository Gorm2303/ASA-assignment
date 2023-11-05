package sdu.asa.inventorysystem.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import sdu.asa.inventorysystem.dto.ItemDto;
import sdu.asa.inventorysystem.models.Item;
import sdu.asa.inventorysystem.service.ItemService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/inventory")
@RequiredArgsConstructor
public class InventoryController {
    private final ItemService itemService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Item> getAllProducts(){
        return itemService.getAllMyEntities();
    }

    @GetMapping("/home")
    public String index() {
        return "Spring Application is Running...";
    }
}
