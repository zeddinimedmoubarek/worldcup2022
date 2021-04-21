package tn.rnu.isi.worldcup.entities;

import java.io.Serializable;
import java.sql.Date;
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
@Table(name = "matche")
public class Matche implements Serializable{
	private static final long serialVersionUID = 1L;
		
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name = "matchid")
		private Long id;
		private Date date_match;
		private int nbr_buts;
		private int heure_match;
		
		@OneToMany(mappedBy = "matche")
		private Set<Spectateur> spectateurs;
		@OneToMany(mappedBy = "matche")
		private Set<Ticket> tickets;
		//constructeur sans parametres
		public Matche() {
			super();
		}
		//constructeur avec tous les parametres
		public Matche(Long id, Date date_match, int nbr_buts, int heure_match, Set<Spectateur> spectateurs) {
			super();
			this.id = id;
			this.date_match = date_match;
			this.nbr_buts = nbr_buts;
			this.heure_match = heure_match;
			this.spectateurs = spectateurs;
		}

		//getters et setters
		public Long getId() {
			return id;
		}
	
		public void setId(Long id) {
			this.id = id;
		}
		public Date getDate_match() {
			return date_match;
		}
		public void setDate_match(Date date_match) {
			this.date_match = date_match;
		}
		public int getNbr_buts() {
			return nbr_buts;
		}
		public void setNbr_buts(int nbr_buts) {
			this.nbr_buts = nbr_buts;
		}
		public int getHeure_match() {
			return heure_match;
		}
		public void setHeure_match(int heure_match) {
			this.heure_match = heure_match;
		}
		public Set<Spectateur> getSpectateurs() {
			return spectateurs;
		}
		public void setSpectateurs(Set<Spectateur> spectateurs) {
			this.spectateurs = spectateurs;
		}
		//methode to string affichage de l'objet
		@Override
		public String toString() {
			return "Matche [id=" + id + ", date_match=" + date_match + ", nbr_buts=" + nbr_buts + ", heure_match="
					+ heure_match + ", spectateurs=" + spectateurs + "]";
		}	
}
