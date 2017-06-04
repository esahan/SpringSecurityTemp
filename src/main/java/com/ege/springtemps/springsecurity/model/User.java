package com.ege.springtemps.springsecurity.model;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.validator.constraints.NotEmpty;


@Entity
@Table(name = "APP_USER", schema = "SECURITY", uniqueConstraints = @UniqueConstraint(columnNames = "SSO_ID"))
public class User implements java.io.Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private BigDecimal id;

	private String ssoId;

	private String password;

	private String firstName;

	private String lastName;

	private String email;

	private Set<UserProfile> userProfiles = new HashSet<UserProfile>(0);

	public User() {
	}

	public User(BigDecimal id, String ssoId, String password,
			String firstName, String lastName, String email) {
		this.id = id;
		this.ssoId = ssoId;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}

	public User(BigDecimal id, String ssoId, String password,
			String firstName, String lastName, String email,
			Set<UserProfile> userProfiles) {
		this.id = id;
		this.ssoId = ssoId;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.userProfiles = userProfiles;
	}

	@Id
	@Column(name = "ID", unique = true, nullable = false, precision = 22, scale = 0)
	@GeneratedValue(generator="user_id_seq" ,strategy=GenerationType.SEQUENCE)
	@SequenceGenerator(name="user_id_seq" , sequenceName="APP_USER_SEQ")
	public BigDecimal getId() {
		return this.id;
	}

	public void setId(BigDecimal id) {
		this.id = id;
	}
	
	@NotEmpty
	@Column(name = "SSO_ID", unique = true, nullable = false, length = 30)
	public String getSsoId() {
		return this.ssoId;
	}

	public void setSsoId(String ssoId) {
		this.ssoId = ssoId;
	}
	
	@NotEmpty
	@Column(name = "PASSWORD", nullable = false, length = 100)
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	@NotEmpty
	@Column(name = "FIRST_NAME", nullable = false, length = 30)
	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	@NotEmpty
	@Column(name = "LAST_NAME", nullable = false, length = 30)
	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	@NotEmpty
	@Column(name = "EMAIL", nullable = false, length = 30)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	@NotEmpty
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "APP_USER_USER_PROFILE", schema = "SECURITY", joinColumns = {
			@JoinColumn(name = "USER_ID", nullable = false, updatable = false) }, inverseJoinColumns = {
					@JoinColumn(name = "USER_PROFILE_ID", nullable = false, updatable = false) })
	public Set<UserProfile> getUserProfiles() {
		return this.userProfiles;
	}

	public void setUserProfiles(Set<UserProfile> userProfiles) {
		this.userProfiles = userProfiles;
	}
}
