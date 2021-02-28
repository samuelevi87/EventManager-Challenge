package br.com.sl3v1.challengeselection.room;

import br.com.sl3v1.challengeselection.enums.RoomStatus;
import br.com.sl3v1.challengeselection.enums.Stage;
import br.com.sl3v1.challengeselection.people.People;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "tb_room")
@Data
public class Room implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // Instruindo o JPA a mapear o ID como chave primária auto
														// incrementável no banco.
	private Long id;

	@Column(name = "name")
	private String name;

	@Column(name = "capacity")
	private int capacity;

	@Column(name = "lotation")
	private Integer lotation;

	@Column(name = "stage")
	private Stage stage;

	@OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
	private List<People> peopleList;

}
