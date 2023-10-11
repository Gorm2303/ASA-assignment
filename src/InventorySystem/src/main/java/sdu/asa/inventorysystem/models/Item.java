package sdu.asa.inventorysystem.models;

import lombok.*;
import org.springframework.context.annotation.Bean;

@Getter
@Builder
@AllArgsConstructor
@Setter
@Data
@NoArgsConstructor
public class Item {
    public int id;
    public String name;

    @Override public String toString() {
        return "{" + "id:" + id + ", name:" + name + "}";
    }
}
