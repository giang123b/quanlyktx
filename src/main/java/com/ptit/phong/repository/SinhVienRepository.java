package com.ptit.phong.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ptit.phong.model.SinhVien;
@Repository
public interface SinhVienRepository extends JpaRepository<SinhVien, Integer>{

}
