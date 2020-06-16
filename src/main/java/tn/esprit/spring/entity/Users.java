package tn.esprit.spring.entity;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;



@Component
@Entity
public class Users implements UserDetails {
	private static final long serialVersionUID = -1396669830860400871L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String nom;

	private String password;

	@Column(unique=true)
	private String email;
	
	@Enumerated(EnumType.STRING)
	private Role roles;
	

	@OneToOne(cascade = CascadeType.ALL, mappedBy = "user")
	private ShoppingCart shoppingCart;
	
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Role getRoles() {
		return roles;
	}
	public void setRoles(Role roles) {
		this.roles = roles;
	}
	
	public Users() {
		super();
		
	}
	public Users(String name, String login, String password, Role role) {
			super();
			this.nom = name;
			this.email = login;
			this.password = password;
			this.roles = role;
		}
	public Users(int id, String name, String login, String password, Role role) {
		super();
		this.id = id;
		this.nom = name;
		this.email = login;
		this.password = password;
		this.roles = role;
	}
	
	/*public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		  List<GrantedAuthority> grantedAuthorityList = new ArrayList<>();
	        SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority(this.getRoles().getType() );
	        grantedAuthorityList.add(simpleGrantedAuthority);
	        return grantedAuthorityList;
	}*/

	public String getUsername() {
		// TODO Auto-generated method stub
		return this.getEmail();
	}
	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
	
	

}
