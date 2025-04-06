package com.example.wms.picking.strategy.impl;

import com.example.wms.picking.strategy.PickingStrategy;
import com.example.wms.picking.strategy.model.OrderItem;

/**
 * 后进先出(LIFO)拣货策略实现类
 * 按照商品入库的相反顺序进行拣货
 */
public class LIFOPickingStrategy implements PickingStrategy {
    /**
     * 执行LIFO拣货操作
     * @param item 需要拣货的订单项
     */
    @Override
    public void pick(OrderItem item) {
        System.out.println("使用LIFO策略拣货: " + item);
        // LIFO拣货具体实现
    }
} 