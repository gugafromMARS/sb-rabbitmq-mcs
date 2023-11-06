package gsc.projects.orderservice.controller;


import gsc.projects.orderservice.model.Order;
import gsc.projects.orderservice.service.OrderService;
import gsc.projects.orderservice.service.OrderServiceImp;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/order")
@AllArgsConstructor
public class OrderController {


    private OrderService orderService;

    @GetMapping("/publish")
    public ResponseEntity<?> send(@RequestBody Order order){
        orderService.sendOrder(order);
        return ResponseEntity.ok("Order sent successfully");
    }
}
