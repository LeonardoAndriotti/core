package com.core.Orders;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;

public class UpdateOrderStatus {

    public OrderStatus updateStatusOrder(OrderStatus order, BigDecimal id) {

       OrderStatus response = validadeStatusOrder(order.getStatus());


        if (response.getStatus().equals("ENTREGUE")) {
            System.out.println("Finalizando Pedido " + response.getStatus());
            updateOrderApi(id, response.getStatus());
            return response;
        }

        System.out.println("Atualizando estados de pedido " + response.getStatus());
        updateOrderApi(BigDecimal.ONE, response.getStatus());

        return updateStatusOrder(response, id);
    }

    private void updateOrderApi(BigDecimal idOrder, String orderStatus) {
        String url = "http://localhost:8980/orders/" + idOrder + "/" + orderStatus;
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response =
                restTemplate.exchange(url,
                        HttpMethod.PUT, null, String.class);
    }


    private OrderStatus validadeStatusOrder(String statusAtual) {
        OrderStatus orderStatus = new OrderStatus();
        if (statusAtual.equals("PENDENTE")) {
            orderStatus.setStatus("APROVADO");
        } else if (statusAtual.equals("APROVADO")) {
            orderStatus.setStatus("ACAMINHO");
        } else if (statusAtual.equals("ACAMINHO")) {
            orderStatus.setStatus("ENTREGUE");
        }

        return orderStatus;
    }

}
