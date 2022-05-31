package com.aisha.skins.entities;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import lombok.Data;
@Data
@Entity
public class User {
@Id
@GeneratedValue (strategy=GenerationType.IDENTITY) 
private Long user_id;
public Long getUser_id() {
	return user_id;
}
public void setUser_id(Long user_id) {
	this.user_id = user_id;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	String hashedPassword = passwordEncoder.encode(password);
	this.password = hashedPassword;
}
public Boolean getEnabled() {
	return enabled;
}
public void setEnabled(Boolean enabled) {
	this.enabled = enabled;
}
public List<Role> getRoles() {
	return roles;
}
public void setRoles(List<Role> roles) {
	this.roles = roles;
}
private String username;
private String password;
private Boolean enabled;
 @ManyToMany(cascade=CascadeType.ALL, fetch = FetchType.EAGER)
@JoinTable(name="user_role",joinColumns = @JoinColumn(name="user_id") , 
 inverseJoinColumns = @JoinColumn(name="role_id")) 
private List<Role> roles;
@Override
public String toString() {
	return "User [user_id=" + user_id + ", username=" + username + ", password=" + password + ", enabled=" + enabled
			+ ", roles=" + roles + "]";
} 
}
