package com.core.controller;

import com.core.Category.CategoryTree;
import com.core.Category.HtmlCategoryMenu;
import com.core.DTO.CategoryDTO;
import com.core.DTO.ProductDTO;
import com.core.SearchProduct.BestPriceByCategory;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
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

        return categoryTree.rootCategory(response.getBody());
    }

    @RequestMapping(value = "/category/html",method = RequestMethod.GET)
    public String searchCategoryHtml() throws RestClientException, IOException {
       return htmlCategoryMenu.genereteHtml(searchCategoryAll());
    }

/*    public static void main(String[]args) throws IOException {
        new SearchController().searchCategoryHtml();
    }*/


}
