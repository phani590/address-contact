/*
 * package com.crm.purple.army.skill.assessment.auth.service;
 * 
 * import java.util.HashSet; import java.util.Set;
 * 
 * import org.springframework.security.core.GrantedAuthority; import
 * org.springframework.security.core.authority.SimpleGrantedAuthority; import
 * org.springframework.security.core.userdetails.UserDetails; import
 * org.springframework.security.core.userdetails.UserDetailsService; import
 * org.springframework.security.core.userdetails.UsernameNotFoundException;
 * import org.springframework.stereotype.Service;
 * 
 * @Service public class UserDetailsServiceImpl implements UserDetailsService{
 * 
 * @Override public UserDetails loadUserByUsername(String username) throws
 * UsernameNotFoundException { Set<GrantedAuthority> grantedAuthorities = new
 * HashSet<>(); grantedAuthorities.add(new SimpleGrantedAuthority("USER"));
 * grantedAuthorities.add(new SimpleGrantedAuthority("ADMIN")); return new
 * org.springframework.security.core.userdetails.User("Contact1", "Contact1",
 * grantedAuthorities); }
 * 
 * }
 */