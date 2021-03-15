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
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;

@DynamicUpdate
@Entity
@Table(name = "equipe")
public class Equipe implements Serializable {
private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "equipeid")
	private Long id;
	private String nom_equipe;
	private String pays;
	private int nbr_joueurs;
	private Blob imageEquipe;
	
	@OneToOne(mappedBy = "equipe")
    private Entraineur entraineur;
	
	@OneToMany(mappedBy="equipe")
    private Set<Joueur> Joueurs;
	
	public Equipe() {
		super();
	}
	
	public Equipe(Long id, String nom_equipe, String pays, int nbr_joueurs, Blob imageEquipe, Entraineur entraineur) {
		super();
		this.id = id;
		this.nom_equipe = nom_equipe;
		this.pays = pays;
		this.nbr_joueurs = nbr_joueurs;
		this.imageEquipe = imageEquipe;
		this.entraineur = entraineur;
	}



	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNom_equipe() {
		return nom_equipe;
	}
	public void setNom_equipe(String nom_equipe) {
		this.nom_equipe = nom_equipe;
	}
	public String getPays() {
		return pays;
	}
	public void setPays(String pays) {
		this.pays = pays;
	}
	public int getNbr_joueurs() {
		return nbr_joueurs;
	}
	public void setNbr_joueurs(int nbr_joueurs) {
		this.nbr_joueurs = nbr_joueurs;
	}
	public Blob getImageEquipe() {
		return imageEquipe;
	}
	public void setImageEquipe(Blob imageEquipe) {
		this.imageEquipe = imageEquipe;
	}

	public Entraineur getEntraineur() {
		return entraineur;
	}

	public void setEntraineur(Entraineur entraineur) {
		this.entraineur = entraineur;
	}

	@Override
	public String toString() {
		return "Equipe [id=" + id + ", nom_equipe=" + nom_equipe + ", pays=" + pays + ", nbr_joueurs=" + nbr_joueurs
				+ ", imageEquipe=" + imageEquipe + ", entraineur=" + entraineur + "]";
	}

	
	
	
}
