package tn.rnu.isi.worldcup.entities;

import java.sql.Blob;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;

@DynamicUpdate
@Entity
@Table(name = "entraineur")
public class Entraineur {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "entraineurid")
	private Long id;
	private String nom_entraineur;
	private Blob image_entraineur;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "equipe_id")
    private Equipe equipe;

	public Entraineur() {
		super();
	}

	public Entraineur(Long id, String nom_entraineur, Blob image_entraineur, Equipe equipe) {
		super();
		this.id = id;
		this.nom_entraineur = nom_entraineur;
		this.image_entraineur = image_entraineur;
		this.equipe = equipe;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNom_entraineur() {
		return nom_entraineur;
	}

	public void setNom_entraineur(String nom_entraineur) {
		this.nom_entraineur = nom_entraineur;
	}

	public Blob getImage_entraineur() {
		return image_entraineur;
	}

	public void setImage_entraineur(Blob image_entraineur) {
		this.image_entraineur = image_entraineur;
	}

	public Equipe getEquipe() {
		return equipe;
	}

	public void setEquipe(Equipe equipe) {
		this.equipe = equipe;
	}

	@Override
	public String toString() {
		return "Entraineur [id=" + id + ", nom_entraineur=" + nom_entraineur + ", image_entraineur=" + image_entraineur
				+ ", equipe=" + equipe + "]";
	}
	
	
	
	
	

}
