package ru.topaztree.topaztree.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.topaztree.topaztree.dto.TopazTreeDto;
import ru.topaztree.topaztree.entity.TopazTreeEntity;
import ru.topaztree.topaztree.repository.TopazTreeRepository;

import java.time.LocalDateTime;
import java.util.ArrayList;

@Service
@AllArgsConstructor
public class TopazTreeService {
    final private TopazTreeRepository topazTreeRepository;
    public int calculateWeightOfTree (TopazTreeDto topazTreeDto) {
        int weight = 0;

        ArrayList<TopazTreeDto> trees = new ArrayList<>();
        trees.add(topazTreeDto);
        int i = 0;

        while (trees.size() > i) {
            weight += trees.get(i).getWeight();
            if (trees.get(i).getChildren() != null) {
                trees.addAll(trees.get(i).getChildren());
            }
            i++;
        }
        return weight;
    }

    public TopazTreeEntity saveInDataBase(TopazTreeDto topazTreeDto) {
        TopazTreeEntity topazTreeEntity = new TopazTreeEntity();
        topazTreeEntity.setRequestTime(LocalDateTime.now());
        topazTreeEntity.setTreeWeight(calculateWeightOfTree(topazTreeDto));
        topazTreeEntity.setTopazTreeDto(topazTreeDto);
        return topazTreeRepository.save(topazTreeEntity);

    }

}
