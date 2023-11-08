package sdu.asa.inventorysystem.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.Update;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import sdu.asa.inventorysystem.dto.ItemDto;
import sdu.asa.inventorysystem.models.Item;
import sdu.asa.inventorysystem.repository.InventoryRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/inventory")
public class InventoryController {
    private final InventoryRepository inventoryRepository;

    @Autowired
    public InventoryController(InventoryRepository inventoryRepository) {
        this.inventoryRepository = inventoryRepository;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Item> getAllProducts(){
        return inventoryRepository.findAll();
    }
    @PostMapping()
    @ResponseStatus(HttpStatus.OK)
    public Item createItem(@RequestBody ItemDto itemDto){
        return inventoryRepository.save(new Item(itemDto.getId(), itemDto.getName(), itemDto.getQuantity()));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteProduct(@PathVariable String id){
        inventoryRepository.deleteById(id);
    }

    @GetMapping("/home")
    public String index() {
        return "Spring Application is Running...";
    }
}
