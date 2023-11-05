package sdu.asa.inventorysystem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.http.HttpStatus;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import sdu.asa.inventorysystem.models.Item;
import sdu.asa.inventorysystem.repository.InventoryRepository;
import sdu.asa.inventorysystem.service.ItemService;

import java.util.List;

@SpringBootApplication
@EnableMongoRepositories
public class InventorySystemApplication {

    @Autowired
    InventoryRepository inventoryRepository;



    public static void main(String[] args) {
        SpringApplication.run(InventorySystemApplication.class, args);
    }

}
