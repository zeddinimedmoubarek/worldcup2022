package tn.rnu.isi.worldcup.entities;

import java.io.Serializable;
import java.sql.Blob;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
	private int nbr_joueurs;
	private Blob image_equipe;
	
	@OneToOne(mappedBy = "equipe")
	private Entraineur entraineur;
	
	@OneToMany(mappedBy = "equipe")
	private Set<Joueur> joueurs;
	
	@ManyToOne
    @JoinColumn(name="pays_id")
	private Pays pays;
	
	public Equipe() {
		super();
	}
	public Equipe(Long id, String nom_equipe, int nbr_joueurs, Blob image_equipe, Entraineur entraineur,
			Set<Joueur> joueurs, Pays pays) {
		super();
		this.id = id;
		this.nom_equipe = nom_equipe;
		this.nbr_joueurs = nbr_joueurs;
		this.image_equipe = image_equipe;
		this.entraineur = entraineur;
		this.joueurs = joueurs;
		this.pays = pays;
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
	public Pays getPays() {
		return pays;
	}
	public void setPays(Pays pays) {
		this.pays = pays;
	}
	public int getNbr_joueurs() {
		return nbr_joueurs;
	}
	public void setNbr_joueurs(int nbr_joueurs) {
		this.nbr_joueurs = nbr_joueurs;
	}
	
	public Blob getImage_equipe() {
		return image_equipe;
	}
	public void setImage_equipe(Blob image_equipe) {
		this.image_equipe = image_equipe;
	}
	public Entraineur getEntraineur() {
		return entraineur;
	}
	public void setEntraineur(Entraineur entraineur) {
		this.entraineur = entraineur;
	}
	public Set<Joueur> getJoueurs() {
		return joueurs;
	}
	public void setJoueurs(Set<Joueur> joueurs) {
		this.joueurs = joueurs;
	}
	@Override
	public String toString() {
		return "Equipe [id=" + id + ", nom_equipe=" + nom_equipe + ", pays=" + pays + ", nbr_joueurs=" + nbr_joueurs
				+ ", image_equipe=" + image_equipe + ", entraineur=" + entraineur + ", joueurs=" + joueurs + "]";
	}
	
	
}
