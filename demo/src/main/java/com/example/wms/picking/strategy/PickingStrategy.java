package com.example.wms.picking.strategy;

import com.example.wms.picking.strategy.model.OrderItem;

/**
 * 拣货策略接口
 * 定义了拣货操作的标准方法
 */
public interface PickingStrategy {
    /**
     * 执行拣货操作
     * @param item 需要拣货的订单项
     */
    void pick(OrderItem item);
} 