package tn.rnu.isi.worldcup.entities;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tournoi")
public class Tournoi {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "tournoi_Id")
	private Integer id;
	@Enumerated(EnumType.STRING)
	@Column(length = 20)
	private ETournoi name;
	/*@OneToMany(mappedBy = "tournoi")
	private Set<Matche> matches;*/
	public Tournoi() {
		super();
	}
	public Tournoi(Integer id, ETournoi name) {
		super();
		this.id = id;
		this.name = name;
	}
	/*public Tournoi(Integer id, ETournoi name, Set<Matche> matches) {
		super();
		this.id = id;
		this.name = name;
		this.matches = matches;
	}*/
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public ETournoi getName() {
		return name;
	}
	public void setName(ETournoi name) {
		this.name = name;
	}
	/*public Set<Matche> getMatches() {
		return matches;
	}
	public void setMatches(Set<Matche> matches) {
		this.matches = matches;
	}*/
	@Override
	public String toString() {
		return "Tournoi [id=" + id + ", name=" + name + "]";
	}
	
}
