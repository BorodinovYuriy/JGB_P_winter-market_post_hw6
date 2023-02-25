package ru.geekbrains.winter.market.api;

import lombok.Builder;

import java.math.BigDecimal;
import java.util.List;

@Builder
public class OrderDto {
    private Long id;
    private String username;
    private List<OrderItemDto> items;
    private String address;
    private String phone;
    private BigDecimal totalPrice;

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public List<OrderItemDto> getItems() {
        return items;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

}
