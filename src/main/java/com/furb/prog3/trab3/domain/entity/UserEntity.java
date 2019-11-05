package com.furb.prog3.trab3.domain.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Table(name = "user")
public class UserEntity extends BaseEntity {

	@Id
	@Column(updatable = false, nullable = false)
	@Size(min = 0, max = 50)
	private String username;

	@Size(min = 0, max = 500)
	private String password;

	private boolean activated;

	@ManyToMany
	@Fetch(FetchMode.JOIN)
	@JoinTable(name = "user_authority", joinColumns = @JoinColumn(name = "username"), inverseJoinColumns = @JoinColumn(name = "authority"))
	private Set<AuthorityEntity> authorities;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isActivated() {
		return activated;
	}

	public void setActivated(boolean activated) {
		this.activated = activated;
	}

	public Set<AuthorityEntity> getAuthorities() {
		return authorities;
	}

	public void setAuthorities(Set<AuthorityEntity> authorities) {
		this.authorities = authorities;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		UserEntity user = (UserEntity) o;

		if (!username.equals(user.username))
			return false;

		return true;
	}

	@Override
	public int hashCode() {
		return username.hashCode();
	}

	@Override
	public String toString() {
		return "User{" + "username='" + username + '\'' + ", password='" + password + '\'' + ", activated='" + activated
				+ '\'' + '\'' + '\'' + ", authorities=" + authorities + '}';
	}

}
