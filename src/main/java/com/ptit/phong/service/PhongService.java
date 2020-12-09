package com.ptit.phong.service;

import java.util.List;

import com.ptit.phong.model.Phong;

public interface PhongService {
	
	public Phong themPhong(Phong phong);
	
	public Phong suaPhong(Phong phong);
	
	public boolean xoaPhongTheoMa(int maPhong);
	
	public List<Phong> dsPhong();
	
	public Phong timPhongTheoMa(int maPhong);
}
