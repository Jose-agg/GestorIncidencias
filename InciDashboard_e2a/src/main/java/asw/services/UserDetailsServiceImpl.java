package asw.services;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import asw.entities.Operator;
import asw.repository.OperatorRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private OperatorRepository operatorRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		Operator operario = operatorRepository.findByUser(username);
		Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
		
		grantedAuthorities.add(new SimpleGrantedAuthority(operario.getRole()));

		User u = new User(operario.getName(), operario.getPassword(), grantedAuthorities);
		return u;

	}
	
}
