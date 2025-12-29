package com.example.shop.order.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderVo {

    private Long orderId;
    private Long userId;
    private String productName;
    private int totalPrice;
    private String status;
    private Date orderDate;


    @Override
    public String toString() {
        return "OrderVO [orderId=" + orderId + ", productName=" + productName + ", status=" + status + "]";
    }
}
