package com.example.demo.service;

import com.example.demo.model.dto.ItemsDto;
import com.example.demo.model.dto.ProductDto;
import com.example.demo.model.dto.RequestDto;
import com.example.demo.model.entity.Clothes;
import com.example.demo.model.entity.Food;
import com.example.demo.model.entity.OrderItem;
import com.example.demo.model.entity.Product;
import com.example.demo.repository.ClothesRepository;
import com.example.demo.repository.FoodRepository;
import com.example.demo.repository.OrderItemRepository;
import com.example.demo.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class OrderService {
    private final FoodRepository foodRepository;
    private final ClothesRepository clothesRepository;
    private final ProductRepository productRepository;
    private final OrderItemRepository orderRepository;

    public OrderItem order(RequestDto requestDto){
        ProductDto item = check_product(requestDto.getItems());
        check_amount(item);
        log.info("주문사항을 저장합니다.");
        OrderItem order = new OrderItem(requestDto);
        orderRepository.save(order);
        return order;
    }

    public ProductDto check_product(ItemsDto itemsDto) {
        log.info("상품을 조회합니다.");
        switch (itemsDto.getItemType()) {
            case "food":
                Food food = foodRepository.findById(itemsDto.getId()).orElseThrow(
                        () -> new NullPointerException("존재하지 않는 아이템입니다."));
                ProductDto productDto_food = new ProductDto(food);
                check_amount(productDto_food);
                food.sell();
                foodRepository.save(food);
                return productDto_food;

            case "clothes":
                Clothes clothes = clothesRepository.findById(itemsDto.getId()).orElseThrow(
                        () -> new NullPointerException("존재하지 않는 아이템입니다."));
                ProductDto productDto_clothes = new ProductDto(clothes);
                check_amount(productDto_clothes);
                clothes.sell();
                clothesRepository.save(clothes);
                return productDto_clothes;

            default:
                throw new NullPointerException("존재하지 않는 카테코리입니다.");
        }
    }

    public void check_amount(ProductDto item){
        if(item.getAmount()>=10){

        }else if(item.getAmount()>0) {
            request_product(item);
        }else{
            request_product(item);
            throw new NullPointerException("재고 없음");
        }
    }

    public void request_product(ProductDto item){
        log.info("입고 요청합니다.");
        item.decode();
        Product product = new Product(item);
        productRepository.save(product);
    }


}
