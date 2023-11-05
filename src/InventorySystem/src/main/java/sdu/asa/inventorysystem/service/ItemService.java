package sdu.asa.inventorysystem.service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sdu.asa.inventorysystem.dto.ItemDto;
import sdu.asa.inventorysystem.models.Item;
import sdu.asa.inventorysystem.repository.InventoryRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ItemService {
    private final InventoryRepository inventoryRepository;

    public Item saveMyEntity(Item entity) {
        return inventoryRepository.save(entity);
    }

    public List<Item> getAllMyEntities() {
        return inventoryRepository.findAll();
    }
}
