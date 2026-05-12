package com.agh.inventory.service;

import com.agh.inventory.entity.Inventory;
import com.agh.inventory.model.InventoryModel;
import com.agh.inventory.model.InventoryRequest;
import com.agh.inventory.repository.InventoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InventoryService {


    private final InventoryRepository inventoryRepository;

    public InventoryService(InventoryRepository inventoryRepository) {
        this.inventoryRepository = inventoryRepository;
    }

    public List<Inventory> findAllInventory(){
        return inventoryRepository.findAll();
    }

    public Inventory addItemToInventory(InventoryRequest inventoryRequest){
        Inventory inventory = new Inventory();
        inventory.setAvailable_quantity(inventoryRequest.getAvailable_quantity());
        inventory.setProduct_id(inventoryRequest.getProduct_id());
        inventory.setWarehouse_id(inventoryRequest.getWarehouse_id());
        inventory.setReserved_quantity(inventoryRequest.getReserved_quantity());
       return inventoryRepository.save(inventory);
    }

    public Inventory updateInventoryItem(InventoryModel inventoryModel){

      Inventory inventory = inventoryRepository.findById(inventoryModel.getProduct_id()).orElseThrow(()->new RuntimeException("There is no item with this id in Inventory"));

      inventory.setAvailable_quantity(inventory.getAvailable_quantity()-inventoryModel.getQuanity());
     return inventoryRepository.save(inventory);

    }
}
