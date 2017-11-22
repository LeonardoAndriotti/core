package com.core.SearchProduct;

import com.core.DTO.ProductDTO;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.*;

public class BestPriceByCategory {

    public static final String URL_PRODUCT = "http://localhost:8092/api/product/";

    public List<ProductDTO> ProductAll() {
        return filterCategoryPrice(search(URL_PRODUCT));
    }

    public List<ProductDTO> ProdutoName(String name) {
        return filterCategoryPrice(search(URL_PRODUCT + name));
    }

    public List<ProductDTO> filterCategoryPrice(List<ProductDTO> productDTOS) {
        Map<BigDecimal, List<ProductDTO>> mapProducts = new HashMap<>();
        for (ProductDTO product : productDTOS) {
            if (mapProducts.containsKey(product.getCategory())) {
                List<ProductDTO> dtos = mapProducts.get(product.getCategory());
                dtos.add(product);
                mapProducts.put(product.getCategory(), dtos);
            } else {
                List<ProductDTO> dtos = new ArrayList<>();
                dtos.add(product);
                mapProducts.put(product.getCategory(), dtos);
            }

        }
        return lowerPrice(mapProducts);
    }

    public List<ProductDTO> lowerPrice(Map<BigDecimal, List<ProductDTO>> map) {
        List<ProductDTO> dtos = new ArrayList<>();
        for (BigDecimal a :
                map.keySet()) {
            if (map.get(a).size() > 3) {
                dtos.add(map.get(a).get(0));
                dtos.add(map.get(a).get(1));
                dtos.add(map.get(a).get(2));
            } else {
                for (ProductDTO dto :
                        map.get(a)) {
                    dtos.add(dto);
                }
            }

        }

        return dtos;
    }

    public List<ProductDTO> search(String url) {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<List<ProductDTO>> response =
                restTemplate.exchange(url,
                        HttpMethod.GET, null, new ParameterizedTypeReference<List<ProductDTO>>() {
                        });
        return response.getBody();
    }

}
