package com.example.jpatestcode.mapping;


import com.example.jpatestcode.mapping.joined.JoinedProduct;
import com.example.jpatestcode.mapping.single.SingleProduct;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import jakarta.persistence.*;

@Entity
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id")
    private Long id;
    private String title;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "joined_id")
    private JoinedProduct joinedProduct;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "single_id")
    private SingleProduct singleProduct;

    @Column(name = "super_id")
    private Long superId;

}