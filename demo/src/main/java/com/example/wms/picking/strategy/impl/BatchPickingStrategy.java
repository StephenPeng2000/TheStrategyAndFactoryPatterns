package com.example.wms.picking.strategy.impl;

import com.example.wms.picking.strategy.PickingStrategy;
import com.example.wms.picking.strategy.model.OrderItem;

/**
 * 批量拣货策略实现类
 * 将多个订单的商品合并在一起进行拣货，提高拣货效率
 */
public class BatchPickingStrategy implements PickingStrategy {
    /**
     * 执行批量拣货操作
     * @param item 需要拣货的订单项
     */
    @Override
    public void pick(OrderItem item) {
        System.out.println("使用批量拣货策略: " + item);
        // 批量拣货具体实现
    }
} 