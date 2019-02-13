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
@Table(name = "Medicine")
public class Medicine {
	@Id
	@SequenceGenerator(name="medicine_seq",sequenceName="medicine_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="medicine_seq")
    @Column(name="idMedicine")
	private @NonNull Long id;
	private  String nameMedicine;

	public Medicine(){
    }

    public Medicine(Long id,String nameMedicine){
        this.nameMedicine = nameMedicine;       
    }

	public String getnameMedicine() {
		return nameMedicine;
	}

	public void setnameMedicine(String nameMedicine) {
		this.nameMedicine = nameMedicine;
	}
}
