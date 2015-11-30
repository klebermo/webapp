package com.kleber.webapp.model.role;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.kleber.webapp.generic.persistence.Model;
import com.kleber.webapp.model.permission.Permission;

@Entity
public class Role extends Model {
	
	@Id
	private String id;
	
	@Column
	private String name;
	
	@ManyToMany
	private List<Permission> permissions;

	@Override
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Permission> getPermissions() {
		return permissions;
	}

	public void setPermissions(List<Permission> permissions) {
		this.permissions = permissions;
	}
	
	@Override
	public String toString() {
		return name;
	}

}
