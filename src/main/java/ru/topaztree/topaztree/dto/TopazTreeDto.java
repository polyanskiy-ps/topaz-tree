package ru.topaztree.topaztree.dto;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.List;

@Data
@Component
public class TopazTreeDto {
    private int weight;
    private List<TopazTreeDto> children;
}