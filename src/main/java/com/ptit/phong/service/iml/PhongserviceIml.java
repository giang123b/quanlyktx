package com.ptit.phong.service.iml;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.ptit.phong.model.Phong;
import com.ptit.phong.repository.PhongReponsitory;
import com.ptit.phong.service.PhongService;

@Service
public class PhongserviceIml implements PhongService {

	@Autowired
	private PhongReponsitory phongRepository;

	@Override
	public Phong themPhong(Phong phong) {
		return phongRepository.save(phong);
	}

	@Override
	public Phong suaPhong(Phong phong) {
		if (ktraPhong(phong.getMaPhong())) {
			return phongRepository.save(phong);
		}
		return null;
	}

	@Override
	public boolean xoaPhongTheoMa(int maPhong) {
		boolean result = false;
		if (ktraPhong(maPhong)) {
			phongRepository.deleteById(maPhong);
			result = true;
		}
		return result;
	}

	@Override
	public List<Phong> dsPhong() {

		List<Phong> danhSachPhong = phongRepository.findAll();
		return danhSachPhong;
	}

	@Override
	public Phong timPhongTheoMa(int maPhong) {
		Phong phong = phongRepository.findById(maPhong).orElse(null);
		return phong;
	}

	private boolean ktraPhong(int maPhong) {
		Phong tontaiP = phongRepository.findById(maPhong).orElse(null);
		if (tontaiP == null) {
			return false;
		}
		return true;
	}

}
