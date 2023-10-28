package com.enigma.tokonyadia.service.impl;

import com.enigma.tokonyadia.entity.Product;
import com.enigma.tokonyadia.entity.ProductPrice;
import com.enigma.tokonyadia.entity.Store;
import com.enigma.tokonyadia.model.request.ProductRequest;
import com.enigma.tokonyadia.model.response.ProductResponse;
import com.enigma.tokonyadia.model.response.StoreResponse;
import com.enigma.tokonyadia.repository.ProductRepository;
import com.enigma.tokonyadia.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final StoreService storeService;
    private final ProductPriceService productPriceService;

    @Override
    public Product create(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product getById(String id) {
        return productRepository.findById(id).get();
    }

    @Override
    public List<Product> getAll() {
        return productRepository.findAll();
    }

    @Override
    public Product update(Product product) {
        Product currentProduct = getById(product.getId());
        if (currentProduct != null){
            return productRepository.save(product);
        }
        return null;
    }

    @Override
    public void delete(String id) {
        productRepository.deleteById(id);
    }

    @Transactional(rollbackOn = Exception.class)
    @Override
    public ProductResponse createProduct(ProductRequest request) {
        //method ini nanti akan create di 2 tabel, 1 di product, 2 di product price
        Store store = storeService.getById(request.getStoreId());

        Product product = Product.builder()
                .name(request.getProductName())
                .description(request.getDescription())
                .build();
        productRepository.saveAndFlush(product);

        ProductPrice productPrice = ProductPrice.builder()
                .price(request.getPrice())
                .stock(request.getStock())
                .product(product)
                .store(store)
                .isActive(true)
                .build();
        productPriceService.create(productPrice);
        return ProductResponse.builder();
                .id(product.getId())
                .productName(product.getName())
                .description(product.getDescription())
                .price(productPrice.getPrice())
                .stock(productPrice.getStock())
                .store(StoreResponse.builder()
                        .id(store.getId())
                        .storeName(store.getName())
                        .address(store.getAddress())
                        .build())
                .build();
    }
}