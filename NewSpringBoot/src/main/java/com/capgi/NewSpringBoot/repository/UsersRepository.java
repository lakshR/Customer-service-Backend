package com.capgi.NewSpringBoot.repository;


import com.capgi.NewSpringBoot.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<Users,Integer> {

}