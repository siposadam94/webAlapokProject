package hu.siposadam.entity;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "category")
public class Category {

    @Id
//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "category_generator")
//    @SequenceGenerator(name = "category_generator", sequenceName = "cat_seq")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
}
