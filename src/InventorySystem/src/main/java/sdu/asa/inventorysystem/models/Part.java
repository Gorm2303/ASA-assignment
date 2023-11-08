package sdu.asa.inventorysystem.models;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Builder
@Setter
@NoArgsConstructor
public class Part {

    private String id;
    private int Quantity;


    public Part(String id, int quantity) {
        this.id = id;
        Quantity = quantity;
    }
}