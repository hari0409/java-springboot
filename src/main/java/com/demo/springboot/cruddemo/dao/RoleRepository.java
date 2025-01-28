package com.demo.springboot.cruddemo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.springboot.cruddemo.entity.Role;

public interface RoleRepository extends JpaRepository<Role, String> {

}
