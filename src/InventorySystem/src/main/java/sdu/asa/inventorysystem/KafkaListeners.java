package sdu.asa.inventorysystem;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import sdu.asa.inventorysystem.dto.ItemDto;
import sdu.asa.inventorysystem.models.Item;
import sdu.asa.inventorysystem.models.Order;
import sdu.asa.inventorysystem.service.ItemService;

import java.util.Random;
import java.util.UUID;

@Component
public class KafkaListeners {

    private final ItemService itemService;

    public KafkaListeners(ItemService itemService) {
        this.itemService = itemService;
    }

    @KafkaListener(topics = "order", groupId = "groupId")
    void listener(Order data){
        System.out.println(data.toString());
        Item item = new Item(data.Id + 1, "Part 1", data.getQuantity());
        itemService.saveMyEntity(item);
    }
}
