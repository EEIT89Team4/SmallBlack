package com.supplier.model;

public class SupplierVO  implements java.io.Serializable{
	private Integer supplier_id;
	private String supplier_name;
	private String chargeperson;
	
	public Integer getSupplier_id() {
		return supplier_id;
	}
	public void setSupplier_id(Integer supplier_id) {
		this.supplier_id = supplier_id;
	}
	public String getSupplier_name() {
		return supplier_name;
	}
	public void setSupplier_name(String supplier_name) {
		this.supplier_name = supplier_name;
	}
	public String getChargeperson() {
		return chargeperson;
	}
	public void setChargeperson(String chargeperson) {
		this.chargeperson = chargeperson;
	}
}
