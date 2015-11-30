package com.kleber.webapp.model.usuario;

import org.springframework.stereotype.Service;

import com.kleber.webapp.generic.service.basicService;

@Service
public class UsuarioService extends basicService<Usuario> {

	public UsuarioService() {
		super(Usuario.class);
	}

}
