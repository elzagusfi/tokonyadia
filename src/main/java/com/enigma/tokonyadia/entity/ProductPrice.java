package com.enigma.tokonyadia.entity;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "m_product")
@Builder(toBuilder = true)
public class ProductPrice {

    @Id
    @GenericGenerator(strategy = "uuid2", name = "system-uuid")
    @GeneratedValue(generator = "system-uuid")
    private String id;

    @Column(name = "stock", nullable = false)
    private Integer stock;

    @Column(name = "price", nullable = false)
    private Long price;

    @Column(name = "is_active", nullable = false)
    private Boolean isActive;

    @JoinColumn(name = "product_id")
    private Product product;

    @ManyToOne
    @JoinColumn(name = "store_id")
    private Store store;
}
