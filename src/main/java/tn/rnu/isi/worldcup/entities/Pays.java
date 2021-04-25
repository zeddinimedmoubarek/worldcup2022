package tn.rnu.isi.worldcup.entities;

import java.io.Serializable;
import java.sql.Blob;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;

@DynamicUpdate
@Entity
@Table(name = "pays")
public class Pays implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "pays_id")
	private Long id;
	private String nomPays;
	private Blob imagePays;
	private Zone zone;
	
	@OneToMany(mappedBy = "pays")
	private Set<Equipe> equipes;
	
	

	public Pays() {
		super();

	}



	public Pays(Long id, String nomPays, Blob imagePays, Zone zone, Set<Equipe> equipes) {
		super();
		this.id = id;
		this.nomPays = nomPays;
		this.imagePays = imagePays;
		this.zone = zone;
		this.equipes = equipes;
	}



	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public String getNomPays() {
		return nomPays;
	}



	public void setNomPays(String nomPays) {
		this.nomPays = nomPays;
	}



	public Blob getImagePays() {
		return imagePays;
	}



	public void setImagePays(Blob imagePays) {
		this.imagePays = imagePays;
	}



	public Zone getZone() {
		return zone;
	}



	public void setZone(Zone zone) {
		this.zone = zone;
	}



	public Set<Equipe> getEquipes() {
		return equipes;
	}



	public void setEquipes(Set<Equipe> equipes) {
		this.equipes = equipes;
	}


	@Override
	public String toString() {
		return "Pays [id=" + id + ", nomPays=" + nomPays + ", imagePays=" + imagePays + ", zone=" + zone + ", equipes="
				+ equipes + "]";
	}
	
	
	
}
