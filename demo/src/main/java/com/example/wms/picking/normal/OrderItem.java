package com.example.wms.picking.normal;

import lombok.Data;

@Data
public class OrderItem {
    private String itemId;
    private String itemName;
    private int quantity;
    private String pickingStrategy;
    
    public OrderItem(String itemId, String itemName, int quantity, String pickingStrategy) {
        this.itemId = itemId;
        this.itemName = itemName;
        this.quantity = quantity;
        this.pickingStrategy = pickingStrategy;
    }
} 