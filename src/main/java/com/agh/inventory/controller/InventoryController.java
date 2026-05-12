package com.agh.inventory.controller;

import com.agh.inventory.entity.Inventory;
import com.agh.inventory.model.InventoryModel;
import com.agh.inventory.model.InventoryRequest;
import com.agh.inventory.model.InventoryResponse;
import com.agh.inventory.service.InventoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/inventory")
public class InventoryController {

    private final InventoryService inventoryService;

    public InventoryController(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }

    @PostMapping("/add")
    public ResponseEntity<InventoryResponse> createInventory(@RequestBody InventoryRequest inventoryRequest){

       Inventory inventory = inventoryService.addItemToInventory(inventoryRequest);
       InventoryResponse response = new InventoryResponse();
       response.setAvailable_quantity(inventory.getAvailable_quantity());
       response.setProduct_id(inventory.getProduct_id());
       response.setReserved_quantity(inventory.getReserved_quantity());
       response.setWarehouse_id(inventory.getWarehouse_id());

       return ResponseEntity.ok(response);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Inventory>> getAllInventory(){

        List<Inventory> inventoryList = inventoryService.findAllInventory();
        return ResponseEntity.ok(inventoryList);
    }

    @PutMapping("/update")
    public ResponseEntity<Inventory> updateInventory(@RequestBody  InventoryModel inventoryModel){
       Inventory inventory = inventoryService.updateInventoryItem(inventoryModel);
       return ResponseEntity.ok(inventory);
    }
}
