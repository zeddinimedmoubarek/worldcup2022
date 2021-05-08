package tn.rnu.isi.worldcup.entities;

import java.io.Serializable;
import java.sql.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
		private String heure_match;
		
		
		
		@OneToMany(mappedBy = "matche")
		private Set<Ticket> tickets;
		
		@OneToMany(mappedBy = "matche")		
		private Set<User> users;
		
		@OneToMany(mappedBy = "matche")
		private Set<Arbitre> arbitres;
		
		@ManyToOne
	    @JoinColumn(name="tournoi_Id")
		private Tournoi tournoi;

		//constructeur sans parametres
		public Matche() {
			super();
		}
		//constructeur avec tous les parametres
		public Matche(Long id, Date date_match, String heure_match, Set<Ticket> tickets, Set<User> users,
				Set<Arbitre> arbitres, Tournoi tournoi) {
			super();
			this.id = id;
			this.date_match = date_match;
			this.heure_match = heure_match;
			this.tickets = tickets;
			this.users = users;
			this.arbitres = arbitres;
			this.tournoi = tournoi;
		}
		
		public Matche(Long id, Date date_match, String heure_match) {
			super();
			this.id = id;
			this.date_match = date_match;
			this.heure_match = heure_match;
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
		
		public String getHeure_match() {
			return heure_match;
		}
		public void setHeure_match(String heure_match) {
			this.heure_match = heure_match;
		}
		
		public Tournoi getTournoi() {
			return tournoi;
		}
		public void setTournoi(Tournoi tournoi) {
			this.tournoi = tournoi;
		}
		
		//methode to string affichage de l'objet
		@Override
		public String toString() {
			return "Matche [id=" + id + ", date_match=" + date_match + ", heure_match=" + heure_match + ", tournoi="
					+ tournoi + ", tickets=" + tickets + ", users=" + users + ", arbitres=" + arbitres + "]";
		}
		
		
		
		
		
		
		
}
