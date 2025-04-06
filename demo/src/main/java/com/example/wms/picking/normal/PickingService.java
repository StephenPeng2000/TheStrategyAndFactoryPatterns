package com.example.wms.picking.normal;

import lombok.Data;
import java.util.ArrayList;
import java.util.List;

@Data
public class PickingService {
    private List<OrderItem> orderItems = new ArrayList<>();
    
    public void addOrderItem(OrderItem item) {
        orderItems.add(item);
    }
    
    public void pickItems() {
        for (OrderItem item : orderItems) {
            if ("FIFO".equals(item.getPickingStrategy())) {
                pickByFIFO(item);
            } else if ("LIFO".equals(item.getPickingStrategy())) {
                pickByLIFO(item);
            } else if ("BATCH".equals(item.getPickingStrategy())) {
                pickByBatch(item);
            }
        }
    }
    
    private void pickByFIFO(OrderItem item) {
        System.out.println("使用FIFO策略拣货: " + item);
        // FIFO拣货逻辑
    }
    
    private void pickByLIFO(OrderItem item) {
        System.out.println("使用LIFO策略拣货: " + item);
        // LIFO拣货逻辑
    }
    
    private void pickByBatch(OrderItem item) {
        System.out.println("使用批量拣货策略: " + item);
        // 批量拣货逻辑
    }
} 