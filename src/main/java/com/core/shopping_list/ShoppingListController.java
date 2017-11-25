package com.core.shopping_list;

import com.core.DTO.ProductDTO;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping(value = "/{api}")
public class ShoppingListController {

    @RequestMapping(value = "/create/new/list/{name}/{description}/{color}", method = RequestMethod.GET)
    public Long createNewList(@PathVariable String name,@PathVariable String description,@PathVariable String color) {

        ShoppingListDTO shoppingList = new ShoppingListDTO();
        shoppingList.setName(name);
        shoppingList.setDescription(description);
        shoppingList.setColor(color);
        shoppingList.setIdClient(1L);

        MultiValueMap<String, String> headers = new LinkedMultiValueMap<String, String>();
        headers.add("HeaderName", "value");
        headers.add("Content-Type", "application/json");

        HttpEntity<?> httpEntity = new HttpEntity<ShoppingListDTO>(shoppingList,headers);
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Long> response
                = restTemplate.exchange("http://localhost:8092/api/shopping/list/products/", HttpMethod.POST, httpEntity, Long.class);

        return response.getBody();
    }


    @RequestMapping(value = "/create/new/list/product/{idList}/{product}/{amount}", method = RequestMethod.GET)
    public List<ShoppingListProductDTO> createNewListProduct(@PathVariable Long idList,@PathVariable String product,
                                     @PathVariable BigDecimal amount) {

        ShoppingListProductDTO shoppingList = new ShoppingListProductDTO();
        shoppingList.setListId(idList);
        shoppingList.setProductName(product);
        shoppingList.setQuantity(amount);
        shoppingList.setBrand("Marca Teste");


        MultiValueMap<String, String> headers = new LinkedMultiValueMap<String, String>();
        headers.add("HeaderName", "value");
        headers.add("Content-Type", "application/json");

        HttpEntity<?> httpEntity = new HttpEntity<ShoppingListProductDTO>(shoppingList,headers);
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<List<ShoppingListProductDTO>> response
                = restTemplate.exchange("http://localhost:8092/api/shoppingList/", HttpMethod.POST, httpEntity, new ParameterizedTypeReference<List<ShoppingListProductDTO>>() {
        });

        return response.getBody();
    }


    @RequestMapping(value = "/list/product/user/{id}", method = RequestMethod.GET)
    public List<ShoppingListDTO> getAllList(@PathVariable Long id) {

        String url = "http://localhost:8092/api/shoppingList/user/"+id;
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<List<ShoppingListDTO>> response =
                restTemplate.exchange(url,
                        HttpMethod.GET, null, new ParameterizedTypeReference<List<ShoppingListDTO>>() {
                        });

        return response.getBody();
    }

    @RequestMapping(value = "/list/product/remove/{id}", method = RequestMethod.GET)
    public void removeItem(@PathVariable Long id) {

        String url = "http://localhost:8092/api/shoppingList/"+id;
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response =
                restTemplate.exchange(url,
                        HttpMethod.DELETE, null, String.class);

    }

    @RequestMapping(value = "/list/product/{id}", method = RequestMethod.GET)
    public List<ShoppingListProductDTO> getProducts(@PathVariable Long id) {

        String url = "http://localhost:8092/api/shoppingList/list/"+id;
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<List<ShoppingListProductDTO>> response =
                restTemplate.exchange(url,
                        HttpMethod.GET, null, new ParameterizedTypeReference<List<ShoppingListProductDTO>>() {
                        });

        return response.getBody();
    }

    @RequestMapping(value = "/shopping/list/{id}", method = RequestMethod.GET)
    public ShoppingListDTO getList(@PathVariable Long id) {

        String url = "http://localhost:8092/api//shopping/list/products/"+id;
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<ShoppingListDTO> response =
                restTemplate.exchange(url,
                        HttpMethod.GET, null, ShoppingListDTO.class);

        return response.getBody();
    }

}
