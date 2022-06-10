package com.api.bonappetit.service;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.api.bonappetit.security.UserDetailsImpl;

@Service
public class PerfilService {

		public static UserDetailsImpl authenticated() {
			Authentication auth = SecurityContextHolder.getContext().getAuthentication();
			if (auth != null) {
				return (UserDetailsImpl) auth.getPrincipal();
			}
			return null;
		}
	}

