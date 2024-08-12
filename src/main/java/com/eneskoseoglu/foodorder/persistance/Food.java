package com.eneskoseoglu.foodorder.persistance;
import jakarta.persistence.Entity;
import lombok.*;
import lombok.experimental.SuperBuilder;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class Food extends Base {
    private String name;
    private String description;
    private Double price;
    private String photoUrl;
}
