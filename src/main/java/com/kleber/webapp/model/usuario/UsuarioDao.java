package com.kleber.webapp.model.usuario;

import org.springframework.stereotype.Repository;

import com.kleber.webapp.generic.persistence.Dao;

@Repository
public class UsuarioDao extends Dao<Usuario> {

	public UsuarioDao() {
		super(Usuario.class);
	}

}
