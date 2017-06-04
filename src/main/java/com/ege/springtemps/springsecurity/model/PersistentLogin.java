package com.ege.springtemps.springsecurity.model;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name = "PERSISTENT_LOGINS", schema = "SECURITY")
public class PersistentLogin implements java.io.Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String username;

	private String series;

	private String token;

	
	private Date lastUsed;

	public PersistentLogin() {
	}

	public PersistentLogin(String username, String series, String token,
			Date lastUsed) {
		this.username = username;
		this.series = series;
		this.token = token;
		this.lastUsed = lastUsed;
	}

	
	@Column(name = "USERNAME", unique = true, nullable = false, length = 64)
	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	@Id
	@Column(name = "SERIES", nullable = false, length = 64)
	public String getSeries() {
		return this.series;
	}

	public void setSeries(String series) {
		this.series = series;
	}

	@Column(name = "TOKEN", nullable = false, length = 64)
	public String getToken() {
		return this.token;
	}

	public void setToken(String token) {
		this.token = token;
	}
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "LAST_USED", nullable = false)
	public Date getLastUsed() {
		return this.lastUsed;
	}

	public void setLastUsed(Date lastUsed) {
		this.lastUsed = lastUsed;
	}
}
