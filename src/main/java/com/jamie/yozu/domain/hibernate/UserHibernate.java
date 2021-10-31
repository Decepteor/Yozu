package com.jamie.yozu.domain.hibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.jamie.yozu.domain.IUser;

@Entity
@Table(name = "USER")
public class UserHibernate extends BaseDomainHibernate implements IUser {
  
  String username;
  String password;
  String emailAdress;
  boolean admin;

  @Override
  @Column(name = "USERNAME")
  public String getUsername() {
    return username;
  }

  @Override
  @Column(name = "PASSWORD")
  public String getPassword() {
    return password;
  }

  @Override
  @Column(name = "EMAIL_ADDRESS")
  public String getEmailAddress() {
    return emailAdress;
  }

  @Override
  @Column(name = "ADMIN")
  public boolean isAdmin() {
    return admin;
  }

  @Override
  public void setUsername(String name) {
    this.username = name;
  }

  @Override
  public void setPassword(String password) {
    this.password = password;
  }

  @Override
  public void setEmailAddress(String address) {
    this.emailAdress = address;
  }

  @Override
  public void setAdmin(boolean admin) {
    this.admin = admin;
  }

}
