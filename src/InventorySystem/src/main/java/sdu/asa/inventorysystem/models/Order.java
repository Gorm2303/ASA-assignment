package sdu.asa.inventorysystem.models;

import lombok.*;

@Getter
@Builder
@AllArgsConstructor
@Setter
@Data
@NoArgsConstructor
public class Order {
    public int Id;
    public int ProductId;
    public int Quantity;

    @Override public String toString() {
        return "{" + "id:" + Id + ", name:" + ProductId + ", quantity:" + Quantity + "}";
    }
}
