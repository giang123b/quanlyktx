package com.ptit.phong.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "khach")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Khach implements Serializable{
	
	@Id
	@Column(name = "cmt")
	private String cmt;
	
	@Column(name = "ten")
	private String ten;
	
	@Column(name = "ngaysinh")
	private Date ngaysinh;
	
	@Id
	@Column(name = "ngayden")
	private Date ngayden;
	
//	@ManyToOne
//	@JoinColumn(name = "ma_SV")
//	private Sinhvien sinhvien;
}
