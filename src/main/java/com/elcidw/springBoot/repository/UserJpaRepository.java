package com.elcidw.springBoot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.elcidw.springBoot.Entity.User;

public interface UserJpaRepository extends JpaRepository<User, Long> {

}
