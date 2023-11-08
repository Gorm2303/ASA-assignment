package sdu.asa.inventorysystem;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import sdu.asa.inventorysystem.dto.ItemDto;
import sdu.asa.inventorysystem.models.Item;
import sdu.asa.inventorysystem.models.Order;
import sdu.asa.inventorysystem.repository.InventoryRepository;

import java.util.Random;
import java.util.UUID;

@Component
public class KafkaListeners {

    private final InventoryRepository inventoryRepository;

    public KafkaListeners(InventoryRepository inventoryRepository) {
        this.inventoryRepository = inventoryRepository;
    }

    @KafkaListener(topics = "order", groupId = "groupId")
    void listener(Order data){
        System.out.println(data.toString());
        Item item = new Item(UUID.randomUUID().toString(), "Part 1", data.getQuantity());
        inventoryRepository.save(item);
    }
}
