package com.core.SearchProduct;

import com.core.DTO.ProductDTO;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        return null;
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
