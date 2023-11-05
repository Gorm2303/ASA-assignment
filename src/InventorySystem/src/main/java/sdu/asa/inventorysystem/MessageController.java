package sdu.asa.inventorysystem;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sdu.asa.inventorysystem.models.Order;

@RestController
@RequestMapping("api/message")
public class MessageController {

    private KafkaTemplate<String, Order> template;

    public MessageController(KafkaTemplate<String, Order> template) {
        this.template = template;
    }

    @GetMapping
    public String publish(){
        try {
            template.send("order", new Order(1, 1,1));
        }
        catch (Exception e){
            return "error";
        }
        return "send";

    }
}
