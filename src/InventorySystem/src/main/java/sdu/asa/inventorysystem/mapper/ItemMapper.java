package sdu.asa.inventorysystem.mapper;

import org.springframework.stereotype.Service;
import sdu.asa.inventorysystem.dto.ItemDto;
import sdu.asa.inventorysystem.models.Item;

import java.util.function.Function;
@Service
public class ItemMapper implements Function<Item, ItemDto>
{
    @Override
    public ItemDto apply(Item item)
    {
        return new ItemDto(item.getId(), item.getName(), item.getQuantity());
    }
}
