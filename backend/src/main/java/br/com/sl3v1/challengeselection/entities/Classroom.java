package br.com.sl3v1.challengeselection.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tb_classroom")
public class Classroom implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) //Instruindo o JPA a mapear o ID como chave primária auto incrementável no banco.
	private Long id;
	private String name;
	private Integer capacity;
	private RoomStatus status;
	private Stage stage;
	
	@ManyToMany
	@JoinTable(name = "tb_classroom_employee",
			joinColumns = )
	private Set<Employee> employees = new HashSet<>();  // Escolhi usar o conjunto ao invés da lista, porque não quero permitir a duplicidade de aluno na sala. Além disso, com o mapeamento usando o JPA, o uso do SET, cria a tabela de associação automaticamente.
	
	public Classroom() {
		
	}

	public Classroom(Long id, String name, Integer capacity, RoomStatus status, Stage stage) {
		super();
		this.id = id;
		this.name = name;
		this.capacity = capacity;
		this.status = status;
		this.stage = stage;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getCapacity() {
		return capacity;
	}

	public void setCapacity(Integer capacity) {
		this.capacity = capacity;
	}

	public RoomStatus getStatus() {
		return status;
	}

	public void setStatus(RoomStatus status) {
		this.status = status;
	}

	public Stage getStage() {
		return stage;
	}

	public void setStage(Stage stage) {
		this.stage = stage;
	}

	public Set<Employee> getEmployees() {
		return employees;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Classroom other = (Classroom) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	
}
