package com.demo.springboot.cruddemo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.springboot.cruddemo.entity.Members;

public interface MemberRepository extends JpaRepository<Members, String> {

}
