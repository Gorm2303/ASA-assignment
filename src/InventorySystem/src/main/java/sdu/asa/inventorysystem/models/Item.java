package sdu.asa.inventorysystem.models;
import jakarta.persistence.Entity;
import lombok.*;
import org.springframework.context.annotation.Bean;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(value = "inventory")
@Builder
@Data
@Getter
@Setter
@NoArgsConstructor
public class Item {
    @Id
    private int id;
    private String name;
    private int Quantity;


    public Item(int id, String name, int quantity) {
        this.id = id;
        this.name = name;
        Quantity = quantity;
    }

}
