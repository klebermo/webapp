package com.kleber.webapp.model.permission;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import com.kleber.webapp.generic.persistence.Model;

@Entity
public class Permission extends Model {
	
	@Id
	private String id;
	
	@Column
	private String name;

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
	
	@Override
	public String toString() {
		return name;
	}	

}
