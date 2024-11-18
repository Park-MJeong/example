package com.sparta.example.dto;

import com.sparta.example.entity.Item;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
public class MarketResponseDto {
    private Long id;
    private String username ;
    private String title;
    private String content;
    private int price;

    public MarketResponseDto(Item item) {
        this.id = item.getId();
        this.username = item.getUsername();
        this.title = item.getTitle();
        this.content = item.getContent();
        this.price = item.getPrice();
    }
}
