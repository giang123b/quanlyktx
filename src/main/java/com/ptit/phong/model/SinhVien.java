package com.ptit.phong.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "sinhvien")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SinhVien implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_sinh_vien")
	private int idSinhVien;
	
	@Column(name = "ma_sv")
	private String masv;
	
	@Column(name = "cmt")
	private String cmt;
	
	@Column(name = "ngaysinh")
	private String ngaysinh;
	
	@Column(name = "lop")
	private String lop;
	
	@Column(name = "quequan")
	private String quequan;

	
	
}
