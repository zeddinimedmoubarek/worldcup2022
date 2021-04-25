package tn.rnu.isi.worldcup.entities;

import java.io.Serializable;

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
@Table(name = "ticket")
public class Ticket implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ticketid")
	private Long id;
	private float prix;
	private int quantite;
	@ManyToOne
    @JoinColumn(name="matchid")
    private Matche matche;
	@ManyToOne
    @JoinColumn(name="panierid")
    private Panier panier;
	@ManyToOne
    @JoinColumn(name="user_id")
    private User user;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public float getPrix() {
		return prix;
	}
	public void setPrix(float prix) {
		this.prix = prix;
	}
	public int getQuantite() {
		return quantite;
	}
	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}
	public Matche getMatche() {
		return matche;
	}
	public void setMatche(Matche matche) {
		this.matche = matche;
	}
	public Ticket(Long id, float prix, int quantite, Matche matche) {
		super();
		this.id = id;
		this.prix = prix;
		this.quantite = quantite;
		this.matche = matche;
	}
	@Override
	public String toString() {
		return "Ticket [id=" + id + ", prix=" + prix + ", quantite=" + quantite + ", matche=" + matche + "]";
	}
	
	
}
