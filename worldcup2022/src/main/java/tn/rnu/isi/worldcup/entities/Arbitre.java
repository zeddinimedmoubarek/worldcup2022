package tn.rnu.isi.worldcup.entities;
import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
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
	private String prenom_arbitre;
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "imageId")
    private ImageModel imageArbitre;
	
	@ManyToOne
	@JoinColumn
	private Matche matche;
	
	public Arbitre() {
		super();
	}

	public Arbitre(Long id, String nom_arbitre,String prenom_arbitre, ImageModel imageArbitre) {
		super();
		this.id = id;
		this.nom_arbitre = nom_arbitre;
		this.prenom_arbitre = prenom_arbitre;
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
	public String getPrenom_arbitre() {
		return prenom_arbitre;
	}
	public void setNom_arbitre(String nom_arbitre) {
		this.nom_arbitre = nom_arbitre;
	}
	public void setPrenom_arbitre(String prenom_arbitre) {
		this.prenom_arbitre = prenom_arbitre;
	}
	public ImageModel getImageArbitre() {
		return imageArbitre;
	}

	public void setImageArbitre(ImageModel imageArbitre) {
		this.imageArbitre = imageArbitre;
	}

	@Override
	public String toString() {
		return "Arbitre [id=" + id + ", nom_arbitre=" + nom_arbitre + ", prenom_arbitre=" + prenom_arbitre + ", imageArbitre=" + imageArbitre + "]";
	}
	
}