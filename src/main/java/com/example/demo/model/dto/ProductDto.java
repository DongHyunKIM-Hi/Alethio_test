package com.example.demo.model.dto;

import com.example.demo.model.entity.Clothes;
import com.example.demo.model.entity.Food;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ProductDto {

    private Long id;
    private Long amount;
    private String name;
    private String itemType;
    private String decodeName;

    public ProductDto(Food food){
        this.id = food.getId();
        this.amount = food.getAmount();
        this.name = food.getName();
        this.itemType = food.getItemType();
    }
    public ProductDto(Clothes clothes){
        this.id = clothes.getId();
        this.amount = clothes.getAmount();
        this.name= clothes.getName();
        this.itemType = clothes.getItemType();
    }

    public void decode(){
        switch (this.itemType){
            case "food":
                this.decodeName = this.getName() + "123";
                break;
            case "clothes":
                this.decodeName = "123" + this.getName();
                break;
            default:
                throw new NullPointerException("카테고리 코드가 잘 못 됬습니다.");
        }
    }
}
