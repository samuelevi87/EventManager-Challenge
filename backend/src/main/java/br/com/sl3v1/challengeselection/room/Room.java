package br.com.sl3v1.challengeselection.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import br.com.sl3v1.challengeselection.people.People;
import lombok.Data;

@Entity
@Table(name = "tb_room")
@Data
public class Room implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) //Instruindo o JPA a mapear o ID como chave primária auto incrementável no banco.
	private Long id;
	private String name;
	private Integer capacity;
	private RoomStatus status;
	private Stage stage;
	
	@ManyToMany
	@JoinTable(name = "tb_room_people",
			joinColumns = @JoinColumn(name = "room_id"),
			inverseJoinColumns = @JoinColumn(name = "people_id"))
	private Set<People> peopleList = new HashSet<>();  // Escolhi usar o conjunto ao invés da lista, porque não quero permitir a duplicidade de aluno na sala. Além disso, com o mapeamento usando o JPA, o uso do SET, cria a tabela de associação automaticamente.
	

}
