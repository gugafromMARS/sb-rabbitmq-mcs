package gsc.projects.orderservice.controller;


import gsc.projects.orderservice.model.Order;
import gsc.projects.orderservice.service.OrderService;
import gsc.projects.orderservice.service.OrderServiceImp;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/order")
@AllArgsConstructor
public class OrderController {


    private OrderService orderService;

    @PostMapping("/publish")
    public ResponseEntity<?> send(@RequestBody Order order){
        orderService.sendOrder(order);
        return ResponseEntity.ok("Order sent successfully");
    }
}
