package tn.rnu.isi.worldcup.entities;
import java.io.Serializable;
import java.sql.Blob;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;

@DynamicUpdate
@Entity
@Table (name = "arbitre")
public class Arbitre implements Serializable {
private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "arbitreid")
	private Long id;
	private String nom_arbitre;
	private Blob imageArbitre;
	
	public Arbitre() {
		super();
	}

	public Arbitre(Long id, String nom_arbitre, Blob imageArbitre) {
		super();
		this.id = id;
		this.nom_arbitre = nom_arbitre;
		this.imageArbitre = imageArbitre;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNom_arbitre() {
		return nom_arbitre;
	}

	public void setNom_arbitre(String nom_arbitre) {
		this.nom_arbitre = nom_arbitre;
	}

	public Blob getImageArbitre() {
		return imageArbitre;
	}

	public void setImageArbitre(Blob imageArbitre) {
		this.imageArbitre = imageArbitre;
	}

	@Override
	public String toString() {
		return "Arbitre [id=" + id + ", nom_arbitre=" + nom_arbitre + ", imageArbitre=" + imageArbitre + "]";
	}
	
}
