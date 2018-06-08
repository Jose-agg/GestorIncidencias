package asw.services;

import org.springframework.stereotype.Service;

@Service
public class RolesService 
{
	String[] roles = {"ROLE_OPERARIO","ROLE_ADMIN"};
	
	public String[] getRoles() {
		return roles;
	}
}
