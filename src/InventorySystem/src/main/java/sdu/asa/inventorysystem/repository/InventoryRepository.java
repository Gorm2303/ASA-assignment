package sdu.asa.inventorysystem.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import sdu.asa.inventorysystem.models.Item;

@Repository
public interface InventoryRepository extends MongoRepository<Item, String> {
}
