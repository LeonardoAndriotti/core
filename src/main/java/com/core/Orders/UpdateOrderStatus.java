package com.core.Orders;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;

public class UpdateOrderStatus {

    public OrderStatus updateStatusOrder(OrderStatus order,BigDecimal id) {

        String url = "http://status.getsandbox.com/orders/" + order.getStatus();
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<OrderStatus> response =
                restTemplate.exchange(url,
                        HttpMethod.GET, null, new ParameterizedTypeReference<OrderStatus>() {
                        });

        if (response.getBody().getStatus().equals("ENTREGUE")) {
           System.out.println("Finalizando Pedido " + response.getBody().getStatus());
            updateOrderApi(id, response.getBody().getStatus());
            return response.getBody();
        }

         System.out.println("Atualizando estados de pedido " + response.getBody().getStatus());
        updateOrderApi(BigDecimal.ONE, response.getBody().getStatus());

        return updateStatusOrder(response.getBody(),id);
    }

    private void updateOrderApi(BigDecimal idOrder, String orderStatus) {
        String url = "http://localhost:8980/orders/" + idOrder + "/" + orderStatus;
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response =
                restTemplate.exchange(url,
                        HttpMethod.PUT, null, String.class);
    }

}
