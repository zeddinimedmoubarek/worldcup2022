package tn.rnu.isi.worldcup.entities;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;


@DynamicUpdate
@Entity
@Table(name = "equipeMatch")
public class EquipeMatch implements Serializable{
private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "equipematchid")
	private Long id;
	@ManyToMany
	Set<Match> match;
	@ManyToMany
	Set<Equipe> equipe;
	public EquipeMatch() {
		super();
	}
	public EquipeMatch(Long id, Set<Match> match, Set<Equipe> equipe) {
		super();
		this.id = id;
		this.match = match;
		this.equipe = equipe;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Set<Match> getMatch() {
		return match;
	}
	public void setMatch(Set<Match> match) {
		this.match = match;
	}
	public Set<Equipe> getEquipe() {
		return equipe;
	}
	public void setEquipe(Set<Equipe> equipe) {
		this.equipe = equipe;
	}
	@Override
	public String toString() {
		return "EquipeMatch [id=" + id + ", match=" + match + ", equipe=" + equipe + "]";
	}
	
}
