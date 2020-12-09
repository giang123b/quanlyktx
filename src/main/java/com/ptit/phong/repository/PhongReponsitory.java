package com.ptit.phong.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ptit.phong.model.Phong;

@Repository
public interface PhongReponsitory extends JpaRepository<Phong, Integer>{

}
