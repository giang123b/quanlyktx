package com.ptit.phong.service;

import java.util.List;

import com.ptit.phong.model.SinhVien;

public interface SinhVienService {
	public SinhVien themSinhVien(SinhVien sinhVien);
	
	public SinhVien suaSinhVien(SinhVien sinhVien);
	
	public boolean xoaSinhVienTheoMa(int idSinhVien);
	
	public List<SinhVien> dsSinhVien();
	
	public SinhVien timSinhVienTheoMa(int idSinhVien);
}
