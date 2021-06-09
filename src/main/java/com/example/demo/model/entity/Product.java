package com.example.demo.model.entity;

import com.example.demo.model.dto.ProductDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@NoArgsConstructor

public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column
    private String name;

    @Column
    private String decodeName;

    @Column
    private Long amount;


    public Product(ProductDto productDto){
        this.name = productDto.getName();
        this.decodeName =productDto.getDecodeName();
        this.amount = productDto.getAmount();
    }
}