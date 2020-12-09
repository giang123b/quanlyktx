package com.ptit.phong.service.iml;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ptit.phong.model.SinhVien;
import com.ptit.phong.repository.SinhVienRepository;
import com.ptit.phong.service.SinhVienService;

@Service
public class SinhVienServiceIml implements SinhVienService {

	@Autowired
	private SinhVienRepository sinhVienRepository;

	@Override
	public SinhVien themSinhVien(SinhVien sinhVien) {
		return sinhVienRepository.save(sinhVien);
	}

	@Override
	public SinhVien suaSinhVien(SinhVien sinhVien) {
		if (ktraSinhVien(sinhVien.getIdSinhVien())) {
			return sinhVienRepository.save(sinhVien);
		}
		return null;
	}

	@Override
	public boolean xoaSinhVienTheoMa(int idSinhVien) {
		boolean result = false;
		if (ktraSinhVien(idSinhVien)) {
			sinhVienRepository.deleteById(idSinhVien);
			result = true;
		}
		return result;
	}

	@Override
	public List<SinhVien> dsSinhVien() {

		List<SinhVien> danhSachsinhVien = sinhVienRepository.findAll();
		return danhSachsinhVien;
	}

	@Override
	public SinhVien timSinhVienTheoMa(int idSinhVien) {
		SinhVien sinhVien = sinhVienRepository.findById(idSinhVien)
				.orElse(null);
		return sinhVien;
	}

	private boolean ktraSinhVien(int idSinhVien) {
		SinhVien tontaiSinhVien = sinhVienRepository.findById(idSinhVien)
				.orElse(null);
		if (tontaiSinhVien == null) {
			return false;
		}
		return true;
	}

	
}