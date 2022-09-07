package com.demo.springbootmvc.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.springbootmvc.Model.DemoUser;

public interface JpaRepo extends JpaRepository<DemoUser, Long>{

}
