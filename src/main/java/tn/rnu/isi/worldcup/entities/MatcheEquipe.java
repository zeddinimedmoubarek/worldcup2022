package tn.rnu.isi.worldcup.entities;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

@Entity
@Table(name = "MatcheEquipe")
public class MatcheEquipe implements Serializable {
	
	@EmbeddedId
	private MatcheEquipePK id;
	
	@ManyToOne
    @MapsId("matche_id") //This is the name of attr in MatcheEquipePK class
    @JoinColumn(name = "matche_id")
    private Matche matche;
	
	@ManyToOne
    @MapsId("equipe_id")
    @JoinColumn(name = "equipe1_id")
    private Equipe equipe1;
	
	@ManyToOne
    @MapsId("equipe_id")
    @JoinColumn(name = "equipe2_id")
    private Equipe equipe2;
	
	private int nbrButsEq1;
	private int nbrButsEq2;
	
	
	public MatcheEquipe() {
		super();
		// TODO Auto-generated constructor stub
	}


	public MatcheEquipe(MatcheEquipePK id, Matche matche, Equipe equipe1, Equipe equipe2, int nbrButsEq1, int nbrButsEq2) {
		super();
		this.id = id;
		this.matche = matche;
		this.equipe1 = equipe1;
		this.equipe2 = equipe2;
		this.nbrButsEq1 = nbrButsEq1;
		this.nbrButsEq2 = nbrButsEq2;
	}


	public MatcheEquipePK getId() {
		return id;
	}


	public void setId(MatcheEquipePK id) {
		this.id = id;
	}


	public Matche getMatche() {
		return matche;
	}


	public void setMatche(Matche matche) {
		this.matche = matche;
	}


	public Equipe getEquipe1() {
		return equipe1;
	}


	public void setEquipe1(Equipe equipe1) {
		this.equipe1 = equipe1;
	}


	public Equipe getEquipe2() {
		return equipe2;
	}


	public void setEquipe2(Equipe equipe2) {
		this.equipe2 = equipe2;
	}


	public int getNbrButsEq1() {
		return nbrButsEq1;
	}


	public void setNbrButsEq1(int nbrButsEq1) {
		this.nbrButsEq1 = nbrButsEq1;
	}


	public int getNbrButsEq2() {
		return nbrButsEq2;
	}


	public void setNbrButsEq2(int nbrButsEq2) {
		this.nbrButsEq2 = nbrButsEq2;
	}
	
	
	
	

}
