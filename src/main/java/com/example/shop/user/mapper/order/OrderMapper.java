package com.example.shop.user.mapper.order;

import com.example.shop.order.domain.OrderVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OrderMapper {
    List<OrderVo> getOrders(Long userId);
}
