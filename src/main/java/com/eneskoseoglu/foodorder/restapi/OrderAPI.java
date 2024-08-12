package com.eneskoseoglu.foodorder.restapi;

import com.eneskoseoglu.foodorder.enums.OrderStatus;
import com.eneskoseoglu.foodorder.generic.dto.ResOrderDTO;
import com.eneskoseoglu.foodorder.models.OrderCreateUpdateModel;
import com.eneskoseoglu.foodorder.services.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
@RequiredArgsConstructor
public class OrderAPI {
    private final OrderService orderService;
    @PostMapping("/add")
    public ResOrderDTO addOrder(@RequestBody OrderCreateUpdateModel model) {
        return ResOrderDTO.of(orderService.saveOrder(model));
    }

    @GetMapping("/getAll")
    public List<ResOrderDTO> getAllOrders(@RequestParam(required = false) OrderStatus status) {
        return status == null ?
                orderService.getAllOrders().stream().map((ResOrderDTO::of)).toList() :
                orderService.getAllOrdersByStatus(status).stream().map((ResOrderDTO::of)).toList();
    }
}
