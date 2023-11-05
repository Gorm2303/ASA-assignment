package sdu.asa.inventorysystem;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import sdu.asa.inventorysystem.models.Order;

@Component
public class KafkaListeners {

    @KafkaListener(topics = "order", groupId = "groupId")
    void listener(Order data){
        System.out.println(data.toString());
    }
}
