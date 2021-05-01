package tn.rnu.isi.worldcup.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class MatcheEquipePK implements Serializable{
	
	@Column(name = "matche_id")
    private Long matche_id;

    @Column(name = "equipe_id")
    private Long equipe_id;

}
