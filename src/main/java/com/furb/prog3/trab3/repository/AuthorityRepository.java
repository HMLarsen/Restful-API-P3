package com.furb.prog3.trab3.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.furb.prog3.trab3.domain.entity.AuthorityEntity;

public interface AuthorityRepository extends JpaRepository<AuthorityEntity, String> {

}
