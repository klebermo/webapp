package com.kleber.webapp.model.usuario;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kleber.webapp.generic.controller.basicController;

@Controller
@RequestMapping("usuario")
public class UsuarioController extends basicController<Usuario> {

	public UsuarioController() {
		super(Usuario.class);
	}

}
