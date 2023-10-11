package sdu.asa.inventorysystem;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import sdu.asa.inventorysystem.models.Item;

@Component
public class KafkaListeners {

    @KafkaListener(topics = "item-received", groupId = "groupId")
    void listener(Item data){
        System.out.println(data.toString());
    }
}
