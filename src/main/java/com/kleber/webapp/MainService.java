package com.kleber.webapp;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kleber.webapp.model.usuario.Usuario;
import com.kleber.webapp.model.usuario.UsuarioDao;

@Service
public class MainService {

	@Autowired
	private UsuarioDao usuario;

	public void signup(Usuario object) {
		object.setPassword( converte(object.getPassword()) );
		this.usuario.insert(object);
	}

	public String converte(String senha) {
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(senha.getBytes());
			byte[] digest = md.digest();

			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < digest.length; i++)
					sb.append(Integer.toString((digest[i] & 0xff) + 0x100, 16).substring(1));

			return sb.toString();
		} catch (Exception e) {
			return null;
		}
	}

}
