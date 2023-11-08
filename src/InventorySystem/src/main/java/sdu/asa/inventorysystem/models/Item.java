package sdu.asa.inventorysystem.models;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(value = "inventory")
@Builder
@Getter
@Setter
@NoArgsConstructor
public class Item {
    @Id
    private String id;
    private String name;
    private int Quantity;


    public Item(String id, String name, int quantity) {
        this.id = id;
        this.name = name;
        Quantity = quantity;
    }

}
