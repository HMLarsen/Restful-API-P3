package com.furb.prog3.trab3.domain.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "authority")
public class AuthorityEntity {

	@Id
	@NotNull
	@Size(min = 0, max = 50)
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		AuthorityEntity authority = (AuthorityEntity) o;

		if (!name.equals(authority.name))
			return false;

		return true;
	}

	@Override
	public int hashCode() {
		return name.hashCode();
	}

	@Override
	public String toString() {
		return "Authority{" + "name='" + name + '\'' + '}';
	}

}
