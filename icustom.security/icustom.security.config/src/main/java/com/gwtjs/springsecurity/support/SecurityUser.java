package com.gwtjs.springsecurity.support;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.gwtjs.springsecurity.entity.SysRole;
import com.gwtjs.springsecurity.entity.SysUser;

public class SecurityUser extends SysUser implements UserDetails {
	private static final long serialVersionUID = 1L;

	public SecurityUser(SysUser user) {
		if (user != null) {
			this.setId(user.getId());
			this.setAccount(user.getAccount());
			this.setUsername(user.getUsername());
			this.setEmail(user.getEmail());
			this.setPassword(user.getPassword());
			this.setSysRoles(user.getSysRoles());
		}
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {

		Collection<GrantedAuthority> authorities = new ArrayList<>();
		Set<SysRole> userRoles = this.getSysRoles();

		if (userRoles != null) {
			for (SysRole role : userRoles) {
				SimpleGrantedAuthority authority = new SimpleGrantedAuthority(
						role.getRolename());
				authorities.add(authority);
			}
		}
		return authorities;
	}

	@Override
	public String getPassword() {
		return super.getPassword();
	}

	@Override
	public String getUsername() {
		return super.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}
}
