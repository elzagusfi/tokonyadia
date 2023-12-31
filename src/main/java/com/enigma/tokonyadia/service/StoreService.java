package com.enigma.tokonyadia.service;

import com.enigma.tokonyadia.entity.Store;
import com.enigma.tokonyadia.model.response.StoreResponse;

import java.util.List;

public interface StoreService {

    Store create(Store store);

    Store getById(String id);

    List<Store> getAll();

    Store update(Store store);

    void delete(String id);

    List<StoreResponse> getAllResponse();

}
