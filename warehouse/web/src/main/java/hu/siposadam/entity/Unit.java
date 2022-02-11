package hu.siposadam.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "unit")
public class Unit {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "unit_generator")
    @SequenceGenerator(name="unit_generator", sequenceName = "unit_seq")
    private Integer id;

    private String name;

    @OneToMany(
            mappedBy = "unit",
            cascade = CascadeType.ALL
    )
    private List<Product> products;
}
