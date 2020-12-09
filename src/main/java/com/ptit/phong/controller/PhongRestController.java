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

import com.ptit.phong.model.Phong;
import com.ptit.phong.service.PhongService;

@RestController
@RequestMapping("/phongs")
public class PhongRestController {

	@Autowired
	private PhongService phongService;

	private static final Logger logger = LoggerFactory.getLogger(PhongRestController.class);

	@PostMapping(produces = "application/json")
	public ResponseEntity<?> themPhong(@RequestBody Phong phong) {
		Phong themP = phongService.themPhong(phong);
		if (themP != null) {
			return new ResponseEntity<>(phong, HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Them moi phong khong thanh cong!!!", HttpStatus.SEE_OTHER);
		}
	}

	@PutMapping(produces = "application/json")
	public ResponseEntity<?> suaPhong(@RequestBody Phong phong) {
		Phong suaP = phongService.suaPhong(phong);
		if (suaP != null) {
			return new ResponseEntity<>(suaP, HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Sua phong khong thanh cong!!!", HttpStatus.SEE_OTHER);
		}
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<?> xoaPhongTheoMa(@PathVariable("id") int maPhong) {
		boolean resultDeleted = phongService.xoaPhongTheoMa(maPhong);
		if (resultDeleted) {
			return new ResponseEntity<>("delete success.", HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Xoa phong khong thanh cong!!!", HttpStatus.SEE_OTHER);
		}
	}

	@GetMapping(value = "/{id}", produces = "application/json")
	public ResponseEntity<?> timPhongTheoMa(@PathVariable("id") int maPhong) {
		Phong timP = phongService.timPhongTheoMa(maPhong);
		if (timP != null) {
			return new ResponseEntity<>(timP, HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Tim phong khong thanh cong!!!", HttpStatus.SEE_OTHER);
		}
	}

//	public ResponseEntity<?> dsPhong(@RequestBody Phong phong){
//		List<Phong> phongs = phongService.dsPhong();
//		return new ResponseEntity<>(phongs, HttpStatus.OK);
//	}

	@GetMapping(produces = "application/json")
	public ResponseEntity<?> dsPhong() {
		List<Phong> danhSachPhong = phongService.dsPhong();
		logger.info("danh sach : {}", danhSachPhong);
		if (danhSachPhong.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<>(danhSachPhong, HttpStatus.OK);
		}
	}

}
