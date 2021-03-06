package com.core.controller;

import com.core.DTO.ShopDTO;
import com.core.service.Geo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GeoController {

    @GetMapping(value = "/shop/{gridCode}")
    public List<ShopDTO> getShopList (@RequestParam("gridCode") String gridCode){
        return Geo.getContainShopList(gridCode);
    }

    public boolean teste(String key){
        return Geo.shopGrid.containsKey(key);
    }

}
