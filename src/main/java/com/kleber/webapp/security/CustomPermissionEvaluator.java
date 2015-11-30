package com.kleber.webapp.security;

import java.io.Serializable;

import org.springframework.security.access.PermissionEvaluator;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

@Component
public class CustomPermissionEvaluator implements PermissionEvaluator {

	public boolean hasPermission(Authentication authentication, Object permission) {
        if (authentication == null || !authentication.isAuthenticated()) {
            return false;
        }
        else {
        	for(GrantedAuthority authority: authentication.getAuthorities()) {
        		if(authority.getAuthority().equals(permission))
        			return true;
        	}
            return false;
        }
	}

	public boolean hasPermission(Authentication authentication, Object targetDomainObject, Object permission) {
        if (authentication == null || !authentication.isAuthenticated()) {
            return false;
        }
        else {
        	for(GrantedAuthority authority: authentication.getAuthorities()) {
        		if(authority.getAuthority().equals(permission))
        			return true;
        	}
            return false;
        }
	}

	public boolean hasPermission(Authentication authentication, Serializable targetId, String targetType, Object permission) {
        if (authentication == null || !authentication.isAuthenticated()) {
            return false;
        }
        else {
        	for(GrantedAuthority authority: authentication.getAuthorities()) {
        		if(authority.getAuthority().equals(permission))
        			return true;
        	}
            return false;
        }
	}

}
