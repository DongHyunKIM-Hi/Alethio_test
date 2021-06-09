package com.example.demo.model.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@NoArgsConstructor

public class Clothes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column
    private Long amount;

    @Column
    private String name;


    @Column
    private String itemType;

    public Clothes(Long amount, String name, String itemType){
        this.amount = amount;
        this.name = name;
        this.itemType =itemType;
    }
    public void sell(){
        this.amount = getAmount() - 1;
    }
}

