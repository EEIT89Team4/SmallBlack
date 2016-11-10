package com.shipments.model;

import java.sql.Date;

public class ShipmentsVO  implements java.io.Serializable{
	private Integer shipments_no;
	private String order_no;
	private String adminster_id;
	private String receipt_name;
	private String receipt_address;
	private String receipt_phone;
	private Date receiptime;
	
	public Integer getShipments_no() {
		return shipments_no;
	}
	public void setShipments_no(Integer shipments_no) {
		this.shipments_no = shipments_no;
	}
	public String getOrder_no() {
		return order_no;
	}
	public void setOrder_no(String order_no) {
		this.order_no = order_no;
	}
	public String getAdminster_id() {
		return adminster_id;
	}
	public void setAdminster_id(String adminster_id) {
		this.adminster_id = adminster_id;
	}
	public String getReceipt_name() {
		return receipt_name;
	}
	public void setReceipt_name(String receipt_name) {
		this.receipt_name = receipt_name;
	}
	public String getReceipt_address() {
		return receipt_address;
	}
	public void setReceipt_address(String receipt_address) {
		this.receipt_address = receipt_address;
	}
	public String getReceipt_phone() {
		return receipt_phone;
	}
	public void setReceipt_phone(String receipt_phone) {
		this.receipt_phone = receipt_phone;
	}
	public Date getReceiptime() {
		return receiptime;
	}
	public void setReceiptime(Date receiptime) {
		this.receiptime = receiptime;
	}
}
