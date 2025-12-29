package com.example.shop.order.service;

import com.example.shop.order.domain.OrderVo;
import com.example.shop.user.mapper.order.OrderMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderMapper orderMapper;

    @Override
    public List<OrderVo> getRecentOrders(Long userId) {
        return orderMapper.getOrders(userId);
    }
}
