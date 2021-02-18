package br.com.sl3v1.challengeselection.people;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "tb_people")
@Data
public class People implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) //Instruindo o JPA a mapear o ID como chave primária auto incrementável no banco.
	private Long id;
	
	@Column(name = "name")
	private String name;
	@Column(name = "surname")
	private String surname;
	
}
