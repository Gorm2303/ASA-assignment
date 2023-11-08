package sdu.asa.inventorysystem;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import sdu.asa.inventorysystem.dto.ItemDto;
import sdu.asa.inventorysystem.models.Item;
import sdu.asa.inventorysystem.models.Order;
import sdu.asa.inventorysystem.models.Part;
import sdu.asa.inventorysystem.repository.InventoryRepository;

import java.util.Random;
import java.util.UUID;

@Component
public class KafkaListeners {

    private final InventoryRepository inventoryRepository;
    private KafkaTemplate<String, Part> template;



    public KafkaListeners(InventoryRepository inventoryRepository, KafkaTemplate<String, Part> template) {
        this.inventoryRepository = inventoryRepository;
        this.template = template;
    }

    @KafkaListener(topics = "order", groupId = "groupId")
    void listener(Order data){
        System.out.println(data.toString());
        System.out.println("Subtracting part from inventory");

        switch (data.ProductId){
            case (1):
                Item item = inventoryRepository.findById("1").get();
                if (item.getQuantity() < data.getQuantity()) {
                    orderMoreParts("order-part", "1", 100);
                    System.out.println("OUT OF PARTS: More Parts Ordered!");
                    item.setQuantity(100);
                    inventoryRepository.save(item);
                }

                item.setQuantity(item.getQuantity() - data.getQuantity());
                inventoryRepository.save(item);
                break;

            case (2):
                Item item2 = inventoryRepository.findById("2").get();
                if (item2.getQuantity() < data.getQuantity()) {
                    orderMoreParts("order-part", "1", 100);
                    System.out.println("OUT OF PARTS: More Parts Ordered!");
                    item2.setQuantity(100);
                    inventoryRepository.save(item2);
                }

                item2.setQuantity(item2.getQuantity() - data.getQuantity());
                inventoryRepository.save(item2);
                break;

            case (3):
                Item item3 = inventoryRepository.findById("3").get();
                if (item3.getQuantity() < data.getQuantity()) {
                    orderMoreParts("order-part", "1", 100);
                    System.out.println("OUT OF PARTS: More Parts Ordered!");
                    item3.setQuantity(100);
                    inventoryRepository.save(item3);
                }

                item3.setQuantity(item3.getQuantity() - data.getQuantity());
                inventoryRepository.save(item3);
                break;
        }

    }

    void orderMoreParts(String topic, String productId, int Quantity){
        template.send(topic, new Part(productId, Quantity));
    }
}
