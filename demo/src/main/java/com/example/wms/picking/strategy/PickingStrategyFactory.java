package com.example.wms.picking.strategy;

import com.example.wms.picking.strategy.impl.BatchPickingStrategy;
import com.example.wms.picking.strategy.impl.FIFOPickingStrategy;
import com.example.wms.picking.strategy.impl.LIFOPickingStrategy;

import java.util.concurrent.ConcurrentHashMap;

/**
 * 拣货策略工厂类
 * 使用ConcurrentHashMap实现策略的懒加载和线程安全
 */
public class PickingStrategyFactory {
    /**
     * 策略缓存，使用ConcurrentHashMap保证线程安全
     * key: 策略类型
     * value: 策略实现类实例
     */
    private static final ConcurrentHashMap<String, PickingStrategy> strategies = new ConcurrentHashMap<>();
    
    /**
     * 获取指定类型的拣货策略
     * 使用computeIfAbsent实现懒加载，保证线程安全
     * @param type 策略类型（FIFO/LIFO/BATCH）
     * @return 对应的拣货策略实例
     * @throws IllegalArgumentException 当策略类型不支持时抛出异常
     */
    public static PickingStrategy getStrategy(String type) {
        return strategies.computeIfAbsent(type, key -> {
            switch (key) {
                case "FIFO":
                    return new FIFOPickingStrategy();
                case "LIFO":
                    return new LIFOPickingStrategy();
                case "BATCH":
                    return new BatchPickingStrategy();
                default:
                    throw new IllegalArgumentException("不支持的拣货策略: " + key);
            }
        });
    }
    
    /**
     * 注册新的拣货策略或替换现有策略
     * 主要用于：
     * 1. 动态扩展新的拣货策略
     * 2. 替换现有策略的实现
     * 3. 测试场景下注册mock策略
     * 
     * @param type 策略类型
     * @param strategy 策略实现类实例
     */
    public static void registerStrategy(String type, PickingStrategy strategy) {
        strategies.put(type, strategy);
    }
} 