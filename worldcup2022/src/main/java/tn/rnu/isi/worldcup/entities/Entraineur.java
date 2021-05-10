package tn.rnu.isi.worldcup.entities;
import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import org.hibernate.annotations.DynamicUpdate;

@DynamicUpdate
@Entity
@Table(name = "entraineur")
public class Entraineur implements Serializable {
private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "entraineurid")
	private Long id;
	private String nom_entraineur;
	private String prenom_entraineur;
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "imageId")
    private ImageModel image_entraineur;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "equipe_id")
    private Equipe equipe;

	public Entraineur() {
		super();
	}

	public Entraineur(Long id, String nom_entraineur,String prenom_entraineur, ImageModel image_entraineur, Equipe equipe) {
		super();
		this.id = id;
		this.nom_entraineur = nom_entraineur;
		this.prenom_entraineur = prenom_entraineur;
		this.image_entraineur = image_entraineur;
		this.equipe = equipe;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNom_entraineur() {
		return nom_entraineur;
	}
	public String getPrenom_entraineur() {
		return prenom_entraineur;
	}
	public void setNom_entraineur(String nom_entraineur) {
		this.nom_entraineur = nom_entraineur;
	}
	public void setprenom_entraineur(String prenom_entraineur) {
		this.prenom_entraineur = prenom_entraineur;
	}

	public ImageModel getImage_entraineur() {
		return image_entraineur;
	}

	public void setImage_entraineur(ImageModel image_entraineur) {
		this.image_entraineur = image_entraineur;
	}

	public Equipe getEquipe() {
		return equipe;
	}

	public void setEquipe(Equipe equipe) {
		this.equipe = equipe;
	}

	@Override
	public String toString() {
		return "Entraineur [id=" + id + ", nom_entraineur=" + nom_entraineur + ", image_entraineur=" + image_entraineur
				+ ", equipe=" + equipe + "]";
	}
	
}
