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
@Table(name = "spectateur")
public class Spectateur implements Serializable{
private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "userid")
	private Long id;
	private String nom;
	private String prenom;
	private Blob image_spec; // mahouch obligatoire 
	
	@ManyToOne
	@JoinColumn(name ="matche_id", nullable = false)
	private Matche matche;
	
	public Spectateur() {
		super();
	}
	public Spectateur(Long id, String nom, String prenom, Blob image_spec, Matche matche) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.image_spec = image_spec;
		this.matche = matche;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public Blob getImage_spec() {
		return image_spec;
	}
	public void setImage_spec(Blob image_spec) {
		this.image_spec = image_spec;
	}
	public Matche getMatche() {
		return matche;
	}
	public void setMatche(Matche matche) {
		this.matche = matche;
	}
	@Override
	public String toString() {
		return "Spectateur [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", image_spec=" + image_spec
				+ ", matche=" + matche + "]";
	}
	
	
}
