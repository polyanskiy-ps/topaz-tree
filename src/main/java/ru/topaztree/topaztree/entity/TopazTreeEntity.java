package ru.topaztree.topaztree.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import liquibase.repackaged.net.sf.jsqlparser.expression.JsonAggregateFunction;
import liquibase.repackaged.net.sf.jsqlparser.expression.JsonExpression;
import lombok.Data;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import ru.topaztree.topaztree.dto.TopazTreeDto;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@TypeDef(name = "jsonb", typeClass = JsonBinaryType.class)
@Table(name = "tree")
public class TopazTreeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "request_time")
    private LocalDateTime requestTime;
    @Column(name = "tree_weight")
    private int treeWeight;
    @Column(name = "topaz_tree", columnDefinition = "jsonb")
    @Type(type = "jsonb")
    private TopazTreeDto topazTreeDto;
}
