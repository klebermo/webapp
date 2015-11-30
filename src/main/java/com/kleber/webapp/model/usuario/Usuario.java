package com.kleber.webapp.model.usuario;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.kleber.webapp.generic.persistence.Model;
import com.kleber.webapp.model.permission.Permission;
import com.kleber.webapp.model.role.Role;

@Entity
public class Usuario extends Model implements UserDetails {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7120399651221920699L;

	@Id
	private String id;
	
	@Column
	private String username;
	
	@Column
	private String password;
	
	@Column
	private String firstName;
	
	@Column
	private String lastName;
	
	@Column
	private String email;
	
	@ManyToMany
	private List<Role> roles;

	@Override
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
	
	@Override
	public String toString() {
		return firstName + " " + lastName;
	}

	public Collection<? extends GrantedAuthority> getAuthorities() {
		return null;
	}

	public boolean isAccountNonExpired() {
		return false;
	}

	public boolean isAccountNonLocked() {
		return false;
	}

	public boolean isCredentialsNonExpired() {
		return false;
	}

	public boolean isEnabled() {
		return false;
	}
	
	public List<String> getRolesAsList(List<Role> list) {
	    List <String> rolesAsList = new ArrayList<String>();
	    for(Role role : list)
	    	for(Permission permission : role.getPermissions())
	    		rolesAsList.add(permission.getName());
	    return rolesAsList;
	}

	public static List<GrantedAuthority> getGrantedAuthorities(List<String> roles) {
	    List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
	    for (String role : roles) authorities.add(new SimpleGrantedAuthority(role));
	    return authorities;
	}

	public Collection<? extends GrantedAuthority> getAuthorities(List<Role> list) {
	    List<GrantedAuthority> authList = getGrantedAuthorities(getRolesAsList(list));
	    return authList;
	}

}
