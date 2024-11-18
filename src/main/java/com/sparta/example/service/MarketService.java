package com.sparta.example.service;

import com.sparta.example.dto.MarketRequestDto;
import com.sparta.example.dto.MarketResponseDto;
import com.sparta.example.entity.Item;
import com.sparta.example.repository.MarketRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MarketService {
    private final MarketRepository marketRepository;

    public MarketService(MarketRepository marketRepository) {
        this.marketRepository = marketRepository;
    }


    public MarketResponseDto createItem(MarketRequestDto dto) {
        Item item = new Item(dto);
        Item saveItem = marketRepository.save(item);
        MarketResponseDto responseDto = new MarketResponseDto(saveItem);
        return responseDto;
    }

    public List<MarketResponseDto> getItems() {
        return marketRepository.findAll()
                .stream()
                .map(MarketResponseDto::new)
                .toList();
    }

    @Transactional
    public MarketResponseDto updateItem(Long id, MarketRequestDto requestDto) {
        Item item = findItem(id);
        item.update(requestDto);
        MarketResponseDto responseDto = new MarketResponseDto(item);
        return responseDto;
    }

    public String deleteItem(Long id) {
        Item item = findItem(id);
        marketRepository.delete(item);
        return "msg:삭제완료";
    }

    public Item findItem(Long id){
        return marketRepository.findById(id).orElseThrow(()->
                new IllegalArgumentException("해당 상품은 존재하지 않습니다."));
    }
}
