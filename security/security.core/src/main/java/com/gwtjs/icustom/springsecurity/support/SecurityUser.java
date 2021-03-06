package com.gwtjs.icustom.springsecurity.support;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.gwtjs.icustom.springsecurity.entity.SysRoleVO;
import com.gwtjs.icustom.springsecurity.entity.SysUserVO;

public class SecurityUser extends SysUserVO implements UserDetails {
	private static final long serialVersionUID = 1L;

	public SecurityUser(SysUserVO user) {
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
		Set<SysRoleVO> userRoles = this.getSysRoles();

		if (userRoles != null) {
			for (SysRoleVO role : userRoles) {
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
