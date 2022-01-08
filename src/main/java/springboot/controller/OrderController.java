package springboot.controller;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springboot.dto.OrderRequest;
import springboot.dto.OrderResponse;
import springboot.model.Order;
import springboot.service.OrderService;
import springboot.util.mapper.EntityDtoConverter;

import java.util.List;

@Api
@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    OrderService orderService;

    @Autowired
    private EntityDtoConverter converter;

    @GetMapping
    public ResponseEntity<List<OrderResponse>> findAll() {

        List<Order> orders = orderService.findAllOrders();

        return new ResponseEntity<List<OrderResponse>>(converter.convertEntitytoDto(orders),
                HttpStatus.OK);
    }

    @GetMapping("/{orderId}")
    public ResponseEntity<OrderResponse> findById(@PathVariable String orderId) {

        Order order = orderService.findOrderById(orderId);

        return new ResponseEntity<OrderResponse>(converter.convertEntitytoDto(order), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<OrderResponse> createOrder(@RequestBody OrderRequest orderRequest) {

        Order order = orderService.createOrder(orderRequest);
        return new ResponseEntity<OrderResponse>(converter.convertEntitytoDto(order), HttpStatus.CREATED);
    }
}
