package com.haythem.persistance;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.AbstractPersistable;

@Entity
@Table(name = "type")
public class Type extends AbstractPersistable<Long> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	@Column(name = "typeName")
	private String typeName;
	
	@Column(name = "MTHTAXE")
	private String MTHTAXE;
	
	@Column(name = "MTTVA")
	private String MTTVA;
	
	@Column(name = "EXONERE")
	private String EXONERE;
	
	@Column(name = "MSP")
	private String MSP;

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public String getMTHTAXE() {
		return MTHTAXE;
	}

	public void setMTHTAXE(String mTHTAXE) {
		MTHTAXE = mTHTAXE;
	}

	public String getMTTVA() {
		return MTTVA;
	}

	public void setMTTVA(String mTTVA) {
		MTTVA = mTTVA;
	}

	public String getEXONERE() {
		return EXONERE;
	}

	public void setEXONERE(String eXONERE) {
		EXONERE = eXONERE;
	}

	public String getMSP() {
		return MSP;
	}

	public void setMSP(String mSP) {
		MSP = mSP;
	}
	
	




}
