package com.jakewharton.pingdom.entities;

import com.jakewharton.pingdom.PingdomEntity;

public class Analysis extends PingdomEntity {
	/**
	 * Serial Version UID.
	 */
	private static final long serialVersionUID = 7129478343144347162L;

	private Integer id;
	private Integer timeFirstTest;
	private Integer timeConfirmTest;
	
	public Integer getId() {
		return this.id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getTimeFirstTest() {
		return this.timeFirstTest;
	}
	public void setTimeFirstTest(Integer timeFirstTest) {
		this.timeFirstTest = timeFirstTest;
	}
	public Integer getTimeConfirmTest() {
		return this.timeConfirmTest;
	}
	public void setTimeConfirmTest(Integer timeConfirmTest) {
		this.timeConfirmTest = timeConfirmTest;
	}
}