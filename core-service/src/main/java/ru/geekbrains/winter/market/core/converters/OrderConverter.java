package ru.geekbrains.winter.market.core.converters;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.geekbrains.winter.market.api.OrderDto;
import ru.geekbrains.winter.market.core.entities.Order;

import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class OrderConverter {
    private final OrderItemConverter orderItemConverter;

    public OrderDto entityToDto(Order order) {
        return OrderDto.builder()
                .id(order.getId())
                .address(order.getAddress())
                .phone(order.getPhone())
                .totalPrice(order.getTotalPrice())
                .username(order.getUsername())
                .items(order.getItems().stream().map(orderItemConverter::entityToDto).collect(Collectors.toList()))
                .build();

    }
}
