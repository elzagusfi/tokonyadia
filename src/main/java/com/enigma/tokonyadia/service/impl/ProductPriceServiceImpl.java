package com.enigma.tokonyadia.service.impl;

import com.enigma.tokonyadia.entity.ProductPrice;
import com.enigma.tokonyadia.repository.ProductPriceRepository;
import com.enigma.tokonyadia.service.ProductPriceService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class ProductPriceServiceImpl implements ProductPriceService {
    private  ProductPriceRepository productPriceRepository;

    @Override
    public ProductPrice create(ProductPrice productPrice){
        return productPriceRepository.save(productPrice);
    }

    @Override
    public ProductPrice getById(String id) {
        return null;
    }

    @Override
    public ProductPrice findProductPriceActive(String productId, Boolean active) {
        return productPriceRepository.findByProduct_IdAndaIsActive(productId, active).orElseThrow();
    }

//    public ProductPriceRepository getProductPriceRepository() {
//    }
}
