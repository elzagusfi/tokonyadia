package com.enigma.tokonyadia.repository;


import com.enigma.tokonyadia.entity.ProductPrice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductPriceRepository extends JpaRepository<ProductPrice, String> {
    //kondisi dimana kita harus pilih dulu price yang aktif atau tidak
    //Query Method
    Optional<ProductPrice> findByProduct_IdAndaIsActive(String productId, Boolean active);
}
