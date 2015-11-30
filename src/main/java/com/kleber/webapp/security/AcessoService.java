package com.kleber.webapp.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.kleber.webapp.model.usuario.Usuario;
import com.kleber.webapp.model.usuario.UsuarioDao;

@Component
public class AcessoService implements UserDetailsService {
	
	@Autowired
	private UsuarioDao dao;

	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario account = (Usuario) dao.select("username", username).get(0);
		
		if(account==null)
			throw new UsernameNotFoundException("No such user: " + username);
		else if (account.getRoles().isEmpty())
			throw new UsernameNotFoundException("User " + username + " has no authorities");
		
		boolean accountIsEnabled = account.isEnabled();
	    boolean accountNonExpired = account.isAccountNonExpired();
	    boolean credentialsNonExpired = account.isAccountNonExpired();
	    boolean accountNonLocked = account.isAccountNonLocked();

	    return new User(account.getUsername(), account.getPassword(), accountIsEnabled, accountNonExpired, credentialsNonExpired, accountNonLocked, account.getAuthorities());
	}

}
