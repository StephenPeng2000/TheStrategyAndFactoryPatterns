package com.example.wms.picking.strategy;

import com.example.wms.picking.strategy.model.OrderItem;
import lombok.Data;
import java.util.ArrayList;
import java.util.List;

/**
 * 拣货服务类
 * 使用策略工厂模式实现不同拣货策略的执行
 */
@Data
public class PickingService {
    /**
     * 待拣货的订单项列表
     */
    private List<OrderItem> orderItems = new ArrayList<>();
    
    /**
     * 添加订单项到待拣货列表
     * @param item 订单项
     */
    public void addOrderItem(OrderItem item) {
        orderItems.add(item);
    }
    
    /**
     * 使用指定的策略执行拣货操作
     * @param strategyType 策略类型（FIFO/LIFO/BATCH）
     * @throws IllegalArgumentException 当策略类型不支持时抛出异常
     */
    public void pickItems(String strategyType) {
        // 从策略工厂获取对应的拣货策略
        PickingStrategy strategy = PickingStrategyFactory.getStrategy(strategyType);
        
        // 遍历所有订单项，使用选定的策略进行拣货
        for (OrderItem item : orderItems) {
            strategy.pick(item);
        }
    }
} 