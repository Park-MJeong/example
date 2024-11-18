package com.sparta.example.controller;

import com.sparta.example.dto.MarketRequestDto;
import com.sparta.example.dto.MarketResponseDto;
import com.sparta.example.service.MarketService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MarketController {

    private final MarketService marketService;
    public MarketController(MarketService marketService) {
        this.marketService = marketService;
    }

//    게시글 작성
    @PostMapping("/post")
    public MarketResponseDto createItem (@RequestBody MarketRequestDto requestDto){
        return marketService.createItem(requestDto);
    }
//    전체리스트
    @GetMapping("post")
    public List<MarketResponseDto> getItems (){
        return marketService.getItems();
    }

////   수정
    @PutMapping("/post/{id}")
    public MarketResponseDto updateItem (@PathVariable Long id, @RequestBody MarketRequestDto requestDto){
        return marketService.updateItem(id,requestDto);
    }
////    삭제
    @DeleteMapping("/post/{id}")
    public String deleteItem (@PathVariable Long id){
        return marketService.deleteItem(id);
    }
}
