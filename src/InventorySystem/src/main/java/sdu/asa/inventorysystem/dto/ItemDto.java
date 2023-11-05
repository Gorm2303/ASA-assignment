package sdu.asa.inventorysystem.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ItemDto {
    private int id;
    private String name;
    private int Quantity;
}
