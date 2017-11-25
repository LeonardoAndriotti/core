package com.core.controller;

import com.core.Category.CategoryTree;
import com.core.Category.HtmlCategoryMenu;
import com.core.DTO.CarrerDTO;
import com.core.DTO.CarrerLeoDTO;
import com.core.DTO.CategoryDTO;
import com.core.DTO.ProductDTO;
import com.core.SearchProduct.BestPriceByCategory;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping(value = "/api")
public class SearchController {

    HtmlCategoryMenu htmlCategoryMenu = new HtmlCategoryMenu();

    @RequestMapping(value = "/{name}",method = RequestMethod.GET)
    public List<ProductDTO> searchProduct(@PathVariable String name) throws RestClientException, IOException {
        BestPriceByCategory bestPriceByCategory = new BestPriceByCategory();
        return bestPriceByCategory.ProdutoName(name);
    }


    @RequestMapping(value = "/",method = RequestMethod.GET)
    public List<ProductDTO> searchProductAll() throws RestClientException, IOException {
        BestPriceByCategory bestPriceByCategory = new BestPriceByCategory();
        return bestPriceByCategory.ProductAll();

    }

    @RequestMapping(value = "/category/all",method = RequestMethod.GET)
    public List<CategoryDTO> searchCategoryAll() throws RestClientException, IOException {
        CategoryTree categoryTree = new CategoryTree();

        String url = "http://localhost:8092/product/category";
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<List<CategoryDTO>> response =
                restTemplate.exchange(url,
                        HttpMethod.GET, null, new ParameterizedTypeReference<List<CategoryDTO>>() {
                        });
            //carrega arvore de categoria falta fazer front
        //return categoryTree.rootCategory(response.getBody());
        return response.getBody();
    }

    @RequestMapping(value = "/category/{id}",method = RequestMethod.GET)
    public List<ProductDTO> searchCategory(@PathVariable Long id) throws RestClientException, IOException {
        CategoryTree categoryTree = new CategoryTree();

        String url = "http://localhost:8092/api/product/category/"+id;
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<List<ProductDTO>> response =
                restTemplate.exchange(url,
                        HttpMethod.GET, null, new ParameterizedTypeReference<List<ProductDTO>>() {
                        });

        return response.getBody();
    }

    @RequestMapping(value = "/category/html",method = RequestMethod.GET)
    public String searchCategoryHtml() throws RestClientException, IOException {
       return htmlCategoryMenu.genereteHtml(searchCategoryAll());
    }

    @RequestMapping(value = "/product/save/carrier/{id}/{quant}/{value}",method = RequestMethod.GET)
    public void search(@PathVariable BigDecimal id,@PathVariable BigDecimal quant,@PathVariable String value) {

        CarrerLeoDTO carrerDTO = new CarrerLeoDTO();
        carrerDTO.setIdproduto(id);
        carrerDTO.setQuant(quant);
        carrerDTO.setPreco(BigDecimal.valueOf(Double.parseDouble(value.replace(",","."))));
        carrerDTO.setIduser(BigDecimal.ONE);

        MultiValueMap<String, String> headers = new LinkedMultiValueMap<String, String>();
        headers.add("HeaderName", "value");
        headers.add("Content-Type", "application/json");

        HttpEntity<?> httpEntity = new HttpEntity<Object>(carrerDTO,headers);
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<CarrerLeoDTO> response
                = restTemplate.exchange("http://localhost:8980/carrer/", HttpMethod.POST, httpEntity, CarrerLeoDTO.class);

    }


}
