package com.kleber.webapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kleber.webapp.model.usuario.Usuario;
import com.kleber.webapp.model.usuario.UsuarioDao;

@Service
public class MainService {
	
	@Autowired
	private UsuarioDao usuario;
	
	public void signup(Usuario object) {
		this.usuario.insert(object);
	}

}
