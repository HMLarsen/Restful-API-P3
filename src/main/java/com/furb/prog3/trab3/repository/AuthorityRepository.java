package com.furb.prog3.trab3.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.furb.prog3.trab3.domain.Authority;

public interface AuthorityRepository extends JpaRepository<Authority, String> {

}
