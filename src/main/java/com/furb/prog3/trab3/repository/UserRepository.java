package com.furb.prog3.trab3.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.furb.prog3.trab3.domain.User;

public interface UserRepository extends JpaRepository<User, String> {

	@Query("SELECT u FROM User u WHERE LOWER(u.username) = LOWER(:username)")
	User findByUsernameCaseInsensitive(@Param("username") String username);

}