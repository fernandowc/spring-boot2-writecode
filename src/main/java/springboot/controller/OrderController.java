package springboot.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springboot.dto.OrderRequest;
import springboot.dto.OrderResponse;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

    @GetMapping
    public ResponseEntity<List<OrderResponse>> findAll() {
        List<OrderResponse> orders = new ArrayList<>();

        OrderResponse response = new OrderResponse();
        response.setAccountId("999999");
        response.setOrderId("111123");
        response.setStatus("PENDING");
        response.setTotalAmount(100.00);
        response.setTotalTax(10.00);
        response.setTransactionDate(new Date());

        OrderResponse response2 = new OrderResponse();
        response2.setAccountId("999991");
        response2.setOrderId("111124");
        response2.setStatus("PENDING");
        response2.setTotalAmount(150.00);
        response2.setTotalTax(19.00);
        response2.setTransactionDate(new Date());

        orders.add(response);
        orders.add(response2);

        return new ResponseEntity<List<OrderResponse>>(orders, HttpStatus.OK);
    }

    @GetMapping("/{orderId}")
    public ResponseEntity<OrderResponse> findById(@PathVariable String orderId) {

        OrderResponse response = new OrderResponse();
        response.setAccountId("999999");
        response.setOrderId(orderId);
        response.setStatus("PENDING");
        response.setTotalAmount(100.00);
        response.setTotalTax(10.00);
        response.setTransactionDate(new Date());

        return new ResponseEntity<OrderResponse>(response, HttpStatus.OK);

    }

    @PostMapping
    public ResponseEntity<OrderResponse> nuevaOrden(@RequestBody OrderRequest payLoad){

        OrderResponse response = new OrderResponse();
        response.setAccountId(payLoad.getAccountId());
        response.setOrderId("9999");
        response.setStatus("PENDING");
        response.setTotalAmount(100.00);
        response.setTotalTax(10.00);
        response.setTransactionDate(new Date());

        return new ResponseEntity<OrderResponse>(response, HttpStatus.CREATED);
    }
}
