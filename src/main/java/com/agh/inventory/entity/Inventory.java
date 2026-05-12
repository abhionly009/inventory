package com.agh.inventory.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Inventory {

    public Inventory() {
    }


    @Id
    @GeneratedValue( strategy = GenerationType.SEQUENCE)
    private long id;


    private long product_id;

    private long available_quantity;

    private long reserved_quantity;

    private long warehouse_id;


    public long getId() {
        return id;
    }


    public long getProduct_id() {
        return product_id;
    }

    public void setProduct_id(long product_id) {
        this.product_id = product_id;
    }

    public long getAvailable_quantity() {
        return available_quantity;
    }

    public void setAvailable_quantity(long available_quantity) {
        this.available_quantity = available_quantity;
    }

    public long getReserved_quantity() {
        return reserved_quantity;
    }

    public void setReserved_quantity(long reserved_quantity) {
        this.reserved_quantity = reserved_quantity;
    }

    public long getWarehouse_id() {
        return warehouse_id;
    }

    public void setWarehouse_id(long warehouse_id) {
        this.warehouse_id = warehouse_id;
    }
}
