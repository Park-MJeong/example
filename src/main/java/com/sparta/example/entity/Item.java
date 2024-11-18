package com.sparta.example.entity;

import com.sparta.example.dto.MarketRequestDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table( name="Item")
    public class Item {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        @Column(name = "title", nullable = false)
        private String title;
        @Column(name = "content", nullable = false)
        private String content;
        @Column(name = "price", nullable = false)
        private int price;
        @Column(name = "username", nullable = false)
        private String username;

        public Item(MarketRequestDto requestDto) {
            this.title = requestDto.getTitle();
            this.content = requestDto.getContent();
            this.price = requestDto.getPrice();
            this.username = requestDto.getUsername();
        }

        public void update(MarketRequestDto requestDto) {
            this.title = requestDto.getTitle();
            this.content = requestDto.getContent();
            this.price = requestDto.getPrice();
            this.username = requestDto.getUsername();
        }
//    public Memo(MemoRequestDto dto){
//        this.username = dto.getUsername();
//        this.contents = dto.getContents();
//    }
//
//    public void update(MemoRequestDto dto){
//        this.username = dto.getUsername();
//        this.contents = dto.getContents();
//    }

    }

