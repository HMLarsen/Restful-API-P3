package com.furb.prog3.trab3.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.furb.prog3.trab3.domain.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, String> {

	@Query("SELECT u FROM UserEntity u WHERE LOWER(u.username) = LOWER(:username)")
	UserEntity findByUsernameCaseInsensitive(@Param("username") String username);

}