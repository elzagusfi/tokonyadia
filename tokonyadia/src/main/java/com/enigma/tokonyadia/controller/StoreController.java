package com.enigma.tokonyadia.controller;

import com.enigma.tokonyadia.entity.Store;
import com.enigma.tokonyadia.service.StoreService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class StoreController {

    @Autowired
    private StoreService storeService;

    @PostMapping(
            path = "/store",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public Store createNewStore(@RequestBody Store store){
        return storeService.create(store);
    }

    @GetMapping(
            path = "/store",
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public List<Store> getAllStores(){
        return storeService.getAll();
    }

    @GetMapping(
            path = "/store/{id}",
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public Store getStoreById(@PathVariable String id){
        return storeService.getById(id);
    }

    @PutMapping(
            path = "/store",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public Store updateStore(@RequestBody Store store){
        return storeService.update(store);
    }

    @DeleteMapping(
            path = "/store/{id}",
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public void deleteStore(@PathVariable String id){
        storeService.delete(id);
    }

}