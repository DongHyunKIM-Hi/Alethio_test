package com.example.demo;

import com.example.demo.model.entity.Clothes;
import com.example.demo.model.entity.Food;
import com.example.demo.repository.ClothesRepository;
import com.example.demo.repository.FoodRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }
    // Week02Application.java 의 main 함수 아래에 붙여주세요.
    @Bean
    public CommandLineRunner demo(ClothesRepository clothesRepository, FoodRepository foodRepository) {
        return (args) -> {
            Clothes clothes = new Clothes(11L,"A청바지", "clothes");
            Food food = new Food(50L, "떡볶이", "food");
            clothesRepository.save(clothes);
            foodRepository.save(food);
        };
    }
}
