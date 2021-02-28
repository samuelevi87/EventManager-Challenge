package br.com.sl3v1.challengeselection.coffee;

import br.com.sl3v1.challengeselection.people.People;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "tb_coffee")
@Data
public class Coffee implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "capacity")
    private int capacity;

    @Column(name = "lotation")
    private Integer lotation;

    @OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
    private List<People> peopleCoffeeList;



}
