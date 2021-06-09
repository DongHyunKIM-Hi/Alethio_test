package com.example.demo.model.entity;


import com.example.demo.model.dto.RequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column
    private String contactEmail;

    @Column
    private String contactName;

    @Column
    private String mobile ;

    @Column
    private Long itemId;

    @Column
    private String itemType;

    public OrderItem(RequestDto requestDto){
        this.contactEmail = requestDto.getContactInfo().getContactEmail().trim();
        this.contactName = requestDto.getContactInfo().getContactName().trim();
        this.mobile = requestDto.getContactInfo().getMobile().trim();
        this.itemId = requestDto.getItems().getId();
        this.itemType = requestDto.getItems().getItemType();
    }
}
