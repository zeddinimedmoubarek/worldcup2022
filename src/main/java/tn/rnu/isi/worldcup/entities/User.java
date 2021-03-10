package tn.rnu.isi.worldcup.entities;
import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;

import com.fasterxml.jackson.annotation.JsonIgnore;



@DynamicUpdate
@Entity
@Table(name = "user")
public class User implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "userid")
	private Long id;
	private String first_name;
	private String last_name;
	private String email;
    private String username;
    @Column
    @JsonIgnore
    private String password;
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "USER_ROLES", joinColumns = {
            @JoinColumn(name = "userid") }, inverseJoinColumns = {
            @JoinColumn(name = "ROLE_ID") })
    private Set<Role> roles;
	//Default Constructor
	public User() {
		super();
	}
	//Constructor
	
	

	public User(Long id, String first_name, String last_name, String email, String username, String password,
			Set<Role> roles) {
		super();
		this.id = id;
		this.first_name = first_name;
		this.last_name = last_name;
		
		this.email = email;
		this.username = username;
		this.password = password;
		this.roles = roles;
	}
	public User(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}



		//Getters & Setters
		 public Set<Role> getRoles() {
		        return roles;
		    }
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", first_name=" + first_name + ", last_name=" + last_name + ", email=" + email
				+ ", username=" + username + ", password=" + password + ", roles=" + roles + "]";
	}
	
	
	
	

	
	
}
