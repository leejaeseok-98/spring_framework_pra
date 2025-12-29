package com.example.shop.order.service;

import com.example.shop.order.domain.OrderVo;

import java.util.List;

public interface OrderService {
    List<OrderVo> getRecentOrders(Long userId);
}
