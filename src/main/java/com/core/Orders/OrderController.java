package com.core.Orders;

import com.core.DTO.ProductDTO;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.List;

@RestController
public class OrderController {

    @RequestMapping(value = "/order/user/{idUser}", method = RequestMethod.GET)
    public List<Order> getOrdersByCart(@PathVariable BigDecimal idUser) {

        String url = "http://localhost:8980/orders/user/" + idUser;
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<List<Order>> response =
                restTemplate.exchange(url,
                        HttpMethod.GET, null, new ParameterizedTypeReference<List<Order>>() {
                        });
        return response.getBody();
    }

    @RequestMapping(value = "/order/{id}", method = RequestMethod.GET)
    public Order getOrdersById(@PathVariable Long id) {

        String url = "http://localhost:8980/orders/" + id;
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Order> response =
                restTemplate.exchange(url,
                        HttpMethod.GET, null, new ParameterizedTypeReference<Order>() {
                        });
        return response.getBody();
    }

    @RequestMapping(value = "/order/update/status/{id}/{status}", method = RequestMethod.PUT)
    public void getUpdateStatus(@PathVariable Long id, @PathVariable String status) {

        String url = "http://localhost:8980/orders/" + id + "/" + status;
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response =
                restTemplate.exchange(url,
                        HttpMethod.PUT, null, String.class);

    }

    @RequestMapping(value = "/update/status/{id}/{status}", method = RequestMethod.GET)
    public void getUpdate(@PathVariable BigDecimal id, @PathVariable String status) {
        UpdateOrderStatus updateOrderStatus = new UpdateOrderStatus();
        Thread thread = new Thread("New Thread") {
            public void run(){
                updateOrderStatus.updateStatusOrder(translateStatus(status), id);
            }
        };
        thread.start();

    }

    private OrderStatus translateStatus(String status) {
        OrderStatus orderStatus = new OrderStatus();
        orderStatus.setStatus(status);
        return orderStatus;
    }

}
