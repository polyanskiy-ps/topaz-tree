package ru.topaztree.topaztree.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import ru.topaztree.topaztree.dto.TopazTreeDto;
import ru.topaztree.topaztree.entity.TopazTreeEntity;
import ru.topaztree.topaztree.repository.TopazTreeRepository;

import java.time.LocalDateTime;

@Service
@Component
public class TopazTreeService {
    @Autowired
    private TopazTreeRepository topazTreeRepository;

    public TopazTreeService(TopazTreeRepository topazTreeRepository) {
        this.topazTreeRepository = topazTreeRepository;
    }

    public int calculateWeight(TopazTreeDto topazTreeDto) {
        int weight = 0;
//      return topazTreeDto.getChildren().stream().mapToInt(TopazTreeDto::getWeight).sum();
        if (topazTreeDto.getChildren() != null) {
            weight += topazTreeDto.getWeight();
            for (TopazTreeDto tree : topazTreeDto.getChildren()) {
                weight += tree.getWeight();

            }
        }
        return weight;
    }

        public TopazTreeEntity saveInDataBase(TopazTreeDto topazTreeDto) {
        TopazTreeEntity topazTreeEntity = new TopazTreeEntity();
        topazTreeEntity.setRequestTime(LocalDateTime.now());
        topazTreeEntity.setTreeWeight(calculateWeight(topazTreeDto));
        topazTreeEntity.setTopazTreeDto(topazTreeDto);

        return topazTreeRepository.save(topazTreeEntity);

    }

    public TopazTreeDto getWeight() {
        TopazTreeEntity topaz = topazTreeRepository.findAll().get(0);

        topazTreeRepository.save(topaz);
        return topazTreeRepository.findAll().get(0).getTopazTreeDto();
    }
}
