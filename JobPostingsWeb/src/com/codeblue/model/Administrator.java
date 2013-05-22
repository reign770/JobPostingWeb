package com.codeblue.model;

import javax.persistence.*;

@Entity
public class Administrator {
	private String account;
	private String password;
	@Id
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "Administrator [account=" + account + ", password=" + password
				+ "]";
	}

}
