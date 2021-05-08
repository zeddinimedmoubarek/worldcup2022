package tn.rnu.isi.worldcup.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class MatcheEquipePK implements Serializable{
	private static final long serialVersionUID = 1L;
	@Column(name = "matche_id")
    private Long matche_id;

    @Column(name = "equipe_id")
    private Long equipe_id;

}
