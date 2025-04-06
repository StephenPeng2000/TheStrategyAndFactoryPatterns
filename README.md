# 策略模式与工厂模式在 WMS 拣货系统中的应用

## 项目简介

本项目是一个基于策略模式和工厂模式的仓库管理系统（WMS）拣货模块的示例实现。通过使用设计模式，实现了灵活、可扩展的拣货策略管理。

## 设计模式说明

### 策略模式（Strategy Pattern）
- 定义了拣货策略的接口 `PickingStrategy`
- 实现了三种具体的拣货策略：
  - FIFO（先进先出）策略
  - LIFO（后进先出）策略
  - 批量拣货策略

### 工厂模式（Factory Pattern）
- 使用 `PickingStrategyFactory` 工厂类管理拣货策略
- 实现了策略的懒加载和线程安全
- 支持动态注册新的拣货策略

## 项目结构

```
src/main/java/com/example/wms/picking/
├── strategy/
│   ├── PickingStrategy.java          # 策略接口
│   ├── PickingStrategyFactory.java   # 策略工厂
│   ├── PickingService.java           # 拣货服务
│   ├── impl/                         # 策略实现
│   │   ├── FIFOPickingStrategy.java
│   │   ├── LIFOPickingStrategy.java
│   │   └── BatchPickingStrategy.java
│   └── model/
│       └── OrderItem.java            # 订单项模型
└── TestPickingDemo.java              # 测试示例
```

## 使用方法

1. 创建拣货服务实例：
```java
PickingService pickingService = new PickingService();
```

2. 添加订单项：
```java
pickingService.addOrderItem(new OrderItem("001", "商品A", 10));
```

3. 使用指定策略执行拣货：
```java
// 使用 FIFO 策略
pickingService.pickItems("FIFO");

// 使用 LIFO 策略
pickingService.pickItems("LIFO");

// 使用批量拣货策略
pickingService.pickItems("BATCH");
```

## 扩展新的拣货策略

1. 实现 `PickingStrategy` 接口：
```java
public class CustomPickingStrategy implements PickingStrategy {
    @Override
    public void pick(OrderItem item) {
        // 实现自定义拣货逻辑
    }
}
```

2. 注册新策略：
```java
PickingStrategyFactory.registerStrategy("CUSTOM", new CustomPickingStrategy());
```

## 技术栈

- Java 11
- Maven
- Lombok

## 项目特点

1. 高扩展性：支持动态添加新的拣货策略
2. 线程安全：使用 ConcurrentHashMap 保证线程安全
3. 代码复用：通过策略模式避免代码重复
4. 易于维护：各策略实现相互独立，便于维护和测试

## 运行示例

运行 `TestPickingDemo` 类可以查看不同拣货策略的执行效果。