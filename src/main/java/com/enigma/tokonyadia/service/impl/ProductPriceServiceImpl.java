package com.enigma.tokonyadia.service.impl;

import com.enigma.tokonyadia.entity.ProductPrice;
import com.enigma.tokonyadia.repository.ProductPriceRepository;
import com.enigma.tokonyadia.service.ProductPriceService;

public class ProductPriceServiceImpl implements ProductPriceService {
    private final ProductPriceRepository productPriceRepository;

    @Override
    public ProductPrice create(ProductPrice productPrice){
        return productPriceRepository.save(productPrice);
    }

    @Override
    public ProductPrice findProductPriceActive(String productId, Boolean active)
        return;

    public ProductPriceRepository getProductPriceRepository() {
        return productPriceRepository.findByProduct_IdAndIsActive(productId,active).or;
    }
}
