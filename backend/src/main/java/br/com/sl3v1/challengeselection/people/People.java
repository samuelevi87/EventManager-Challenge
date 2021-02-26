package br.com.sl3v1.challengeselection.people;

import br.com.sl3v1.challengeselection.coffee.Coffee;
import br.com.sl3v1.challengeselection.room.Room;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "tb_people")
@Data
public class People implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Instruindo o JPA a mapear o ID como chave primária auto-incrementável no banco

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "room_id" )
    private Long roomId;

    @OneToOne
    @JoinColumn(name = "room_id", insertable = false, updatable = false)
    private Room room;

    @Column(name = "coffee_id" )
    private Long coffeeId;

    @OneToOne
    @JoinColumn(name = "coffee_id", insertable = false, updatable = false)
    private Coffee coffee;

}
