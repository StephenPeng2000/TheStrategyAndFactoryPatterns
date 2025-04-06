package com.example.wms.picking.strategy.model;

import lombok.Data;

/**
 * 订单项实体类
 * 表示需要拣货的商品信息
 */
@Data
public class OrderItem {
    /**
     * 商品ID
     */
    private String itemId;
    
    /**
     * 商品名称
     */
    private String itemName;
    
    /**
     * 商品数量
     */
    private int quantity;
    
    /**
     * 构造函数
     * @param itemId 商品ID
     * @param itemName 商品名称
     * @param quantity 商品数量
     */
    public OrderItem(String itemId, String itemName, int quantity) {
        this.itemId = itemId;
        this.itemName = itemName;
        this.quantity = quantity;
    }
} 