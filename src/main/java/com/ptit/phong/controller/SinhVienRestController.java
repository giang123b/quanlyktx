package com.ptit.phong.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ptit.phong.model.SinhVien;
import com.ptit.phong.service.SinhVienService;

@RestController
@RequestMapping("/sinhvien")
public class SinhVienRestController {

	@Autowired
	private SinhVienService sinhVienService;

	private static final Logger logger = LoggerFactory.getLogger(
			SinhVienRestController.class);

	@PostMapping(produces = "application/json")
	public ResponseEntity<?> themSinhVien(@RequestBody SinhVien sinhVien) {
		SinhVien themSinhVien = sinhVienService.themSinhVien(sinhVien);
		if (themSinhVien != null) {
			return new ResponseEntity<>(sinhVien, HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Them moi Sinh Vien khong thanh cong!!!", 
					HttpStatus.SEE_OTHER);
		}
	}

	@PutMapping(produces = "application/json")
	public ResponseEntity<?> suaSinhVien(@RequestBody SinhVien sinhVien) {
		SinhVien suaSinhVien = sinhVienService.suaSinhVien(sinhVien);
		if (suaSinhVien != null) {
			return new ResponseEntity<>(sinhVien, HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Sua Sinh Vien khong thanh cong!!!", HttpStatus.SEE_OTHER);
		}
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<?> xoaSinhVienTheoMa(@PathVariable("id") int idSinhVien) {
		boolean resultDeleted = sinhVienService.xoaSinhVienTheoMa(idSinhVien);
		if (resultDeleted) {
			return new ResponseEntity<>("delete success.", HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Xoa Sinh Vien khong thanh cong!!!", HttpStatus.SEE_OTHER);
		}
	}

	@GetMapping(value = "/{id}", produces = "application/json")
	public ResponseEntity<?> timSinhVienTheoMa(@PathVariable("id") int idSinhVien) {
		SinhVien timSinhVien = sinhVienService.timSinhVienTheoMa(idSinhVien);
		if (timSinhVien != null) {
			return new ResponseEntity<>(timSinhVien, HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Tim Sinh Vien khong thanh cong!!!", HttpStatus.SEE_OTHER);
		}
	}


	@GetMapping(produces = "application/json")
	public ResponseEntity<?> dsSinhVien() {
		List<SinhVien> danhSachSinhVien= sinhVienService.dsSinhVien();
		logger.info("danh sach : {}", danhSachSinhVien);
		if (danhSachSinhVien.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<>(danhSachSinhVien, HttpStatus.OK);
		}
	}
}
