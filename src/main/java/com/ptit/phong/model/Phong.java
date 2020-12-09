package com.ptit.phong.model;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "phong")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Phong implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ma_phong")
	private int maPhong;
	
	@Column(name = "loai")
	private String loai;
	
	@Column(name = "dongia")
	private int dongia;
	
	@Column(name = "songuoi")
	private int songuoi;
	
//	@OneToMany(mappedBy = "phong", cascade = CascadeType.ALL)
//	@EqualsAndHashCode.Exclude
//	@ToString.Exclude
//	private Collection<Sinhvien> sinhviens;
}
