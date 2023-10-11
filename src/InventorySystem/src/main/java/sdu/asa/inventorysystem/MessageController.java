package sdu.asa.inventorysystem;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sdu.asa.inventorysystem.models.Item;

@RestController
@RequestMapping("api/message")
public class MessageController {

    private KafkaTemplate<String, Item> template;

    public MessageController(KafkaTemplate<String, Item> template) {
        this.template = template;
    }

    @GetMapping
    public String publish(){
        try {
            template.send("item-received", new Item(1, "test"));
        }
        catch (Exception e){
            return "error";
        }
        return "send";

    }
}
