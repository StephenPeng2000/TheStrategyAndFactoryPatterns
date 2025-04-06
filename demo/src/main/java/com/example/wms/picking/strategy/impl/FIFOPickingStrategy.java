package com.example.wms.picking.strategy.impl;

import com.example.wms.picking.strategy.PickingStrategy;
import com.example.wms.picking.strategy.model.OrderItem;

/**
 * 先进先出(FIFO)拣货策略实现类
 * 按照商品入库的先后顺序进行拣货
 */
public class FIFOPickingStrategy implements PickingStrategy {
    /**
     * 执行FIFO拣货操作
     * @param item 需要拣货的订单项
     */
    @Override
    public void pick(OrderItem item) {
        System.out.println("使用FIFO策略拣货: " + item);
        // FIFO拣货具体实现
    }
} 