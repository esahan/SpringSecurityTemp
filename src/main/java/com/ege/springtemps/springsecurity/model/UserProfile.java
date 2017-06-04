package com.ege.springtemps.springsecurity.model;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;


@Entity
@Table(name = "USER_PROFILE", schema = "SECURITY", uniqueConstraints = @UniqueConstraint(columnNames = "TYPE"))
public class UserProfile implements java.io.Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private BigDecimal id;

	private String type;

	private Set<User> appUsers = new HashSet<User>(0);

	public UserProfile() {
	}

	public UserProfile(BigDecimal id, String type) {
		this.id = id;
		this.type = type;
	}

	public UserProfile(BigDecimal id, String type, Set<User> appUsers) {
		this.id = id;
		this.type = type;
		this.appUsers = appUsers;
	}

	@Id
	@Column(name = "ID", unique = true, nullable = false, precision = 22, scale = 0)
	public BigDecimal getId() {
		return this.id;
	}

	public void setId(BigDecimal id) {
		this.id = id;
	}

	@Column(name = "TYPE", unique = true, nullable = false, length = 30)
	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "APP_USER_USER_PROFILE", schema = "SECURITY", joinColumns = {
			@JoinColumn(name = "USER_PROFILE_ID", nullable = false, updatable = false) }, inverseJoinColumns = {
					@JoinColumn(name = "USER_ID", nullable = false, updatable = false) })
	public Set<User> getAppUsers() {
		return this.appUsers;
	}

	public void setAppUsers(Set<User> appUsers) {
		this.appUsers = appUsers;
	}
}
