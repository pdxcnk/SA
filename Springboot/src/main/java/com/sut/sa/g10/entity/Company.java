package com.sut.sa.g10.entity;

import lombok.*;

import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.SequenceGenerator;
import javax.persistence.GenerationType;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.validation.constraints.NotNull;
import java.util.List;
import javax.persistence.*;

@Entity
@Data
@Table(name = "Company")
public class Company {
	@Id
	@SequenceGenerator(name="company_seq",sequenceName="company_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="company_seq")
    @Column(name="idCompany")
	private @NonNull Long id;
	private @NonNull String nameCompany;
	private @NonNull String phone;
	private @NonNull String address;
	public Company() {}

    public Company (Long id,String nameCompany,String phone,String address){
        this.nameCompany = nameCompany;
        this.phone = phone;
        this.address = address;
           }

	public String getNameCompany() {
		return nameCompany;
	}

	public void setNameCompany(String nameCompany) {
		this.nameCompany = nameCompany;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
}
