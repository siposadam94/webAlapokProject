package hu.siposadam.entity;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "unit")
public class Unit {

    @Id
//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "unit_generator")
//    @SequenceGenerator(name = "unit_generator", sequenceName = "unit_seq")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
}
