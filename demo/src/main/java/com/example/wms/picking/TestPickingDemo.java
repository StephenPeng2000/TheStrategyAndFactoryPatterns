package com.example.wms.picking;

import com.example.wms.picking.normal.OrderItem;
import com.example.wms.picking.normal.PickingService;

public class TestPickingDemo {
    public static void main(String[] args) {
        // 测试普通实现方式
        System.out.println("=== 普通实现方式 ===");
        PickingService normalService = new PickingService();
        normalService.addOrderItem(new OrderItem("001", "商品A", 10, "FIFO"));
        normalService.addOrderItem(new OrderItem("002", "商品B", 5, "LIFO"));
        normalService.addOrderItem(new OrderItem("003", "商品C", 8, "BATCH"));
        normalService.pickItems();
        
        // 测试策略工厂实现方式
        System.out.println("\n=== 策略工厂实现方式 ===");
        com.example.wms.picking.strategy.PickingService strategyService = new com.example.wms.picking.strategy.PickingService();
        strategyService.addOrderItem(new com.example.wms.picking.strategy.model.OrderItem("001", "商品A", 10));
        strategyService.addOrderItem(new com.example.wms.picking.strategy.model.OrderItem("002", "商品B", 5));
        strategyService.addOrderItem(new com.example.wms.picking.strategy.model.OrderItem("003", "商品C", 8));
        
        // 使用不同的策略进行拣货
        System.out.println("\n使用FIFO策略:");
        strategyService.pickItems("FIFO");
        
        System.out.println("\n使用LIFO策略:");
        strategyService.pickItems("LIFO");
        
        System.out.println("\n使用批量拣货策略:");
        strategyService.pickItems("BATCH");
    }
} 