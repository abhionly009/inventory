package com.agh.inventory.controller;

import com.agh.inventory.entity.Inventory;
import com.agh.inventory.model.InventoryRequest;
import com.agh.inventory.service.InventoryService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import static org.mockito.Mockito.when;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(InventoryController.class)
public class InventoryControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    InventoryService inventoryService;

    @Test
    void testCreateInventory() throws Exception{

        Inventory inventory = new Inventory();
        inventory.setReserved_quantity(20);
        inventory.setProduct_id(12);
        inventory.setAvailable_quantity(400);
        inventory.setWarehouse_id(3);

        String requestJson = """
     {
                     "product_id":12,
                     "available_quantity":190,
                     "reserved_quantity":25,
                     "warehouse_id":120
                
                 }
    """;

        when(inventoryService.addItemToInventory(any(InventoryRequest.class))).thenReturn(inventory);

        mockMvc.perform(post("/inventory/add").contentType(MediaType.APPLICATION_JSON)
                .content(requestJson))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.product_id").value("12"));
    }


}
