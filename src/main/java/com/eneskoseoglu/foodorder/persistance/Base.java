package com.eneskoseoglu.foodorder.persistance;

import jakarta.persistence.*;
import lombok.*;

import lombok.experimental.SuperBuilder;

@MappedSuperclass
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public abstract class Base {
    @SequenceGenerator(name = "sequence",sequenceName = "sequence",schema = "org.hibernate.id.enhanced.SequenceStyleGenerator")
    @Id
    @GeneratedValue(generator = "sequence", strategy = GenerationType.SEQUENCE)
    private Long id;
}
