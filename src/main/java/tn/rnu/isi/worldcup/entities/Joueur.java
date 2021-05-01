package tn.rnu.isi.worldcup.entities;
import java.io.Serializable;
import java.sql.Blob;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;

@DynamicUpdate
@Entity
@Table(name = "joueur")
public class Joueur implements Serializable {
private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "joueurid")
	private Long id;
	private String nomJoueur;
	private String prenomJoueur;

	private String position;
	private Blob imageJoueur;
	
	@ManyToOne
    @JoinColumn(name="equipe_id")
    private Equipe equipe;

	public Joueur() {
		super();
	}

	public Joueur(Long id, String nomJoueur,String prenomJoueur, String position, Blob imageJoueur, Equipe equipe) {
		super();
		this.id = id;
		this.nomJoueur = nomJoueur;
		this.prenomJoueur = prenomJoueur;
		this.position = position;
		this.imageJoueur = imageJoueur;
		this.equipe = equipe;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomJoueur() {
		return nomJoueur;
	}

	
	public String getPrenomJoueur() {
		return prenomJoueur;
	}

	public void setPrenomJoueur(String prenomJoueur) {
		this.prenomJoueur = prenomJoueur;
	}

	public void setNomJoueur(String nomJoueur) {
		this.nomJoueur = nomJoueur;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public Blob getImageJoueur() {
		return imageJoueur;
	}

	public void setImageJoueur(Blob imageJoueur) {
		this.imageJoueur = imageJoueur;
	}

	public Equipe getEquipe() {
		return equipe;
	}

	public void setEquipe(Equipe equipe) {
		this.equipe = equipe;
	}

	@Override
	public String toString() {
		return "Joueur [id=" + id + ", nomJoueur=" + nomJoueur + ", prenomJoueur=" + prenomJoueur +", position=" + position + ", imageJoueur="
				+ imageJoueur + ", equipe=" + equipe + "]";
	}
}
