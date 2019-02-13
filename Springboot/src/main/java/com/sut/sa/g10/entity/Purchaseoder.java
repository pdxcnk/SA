package com.sut.sa.g10.entity;
import lombok.*;
import javax.persistence.Id;
import javax.persistence.*;
import javax.persistence.GeneratedValue;
import javax.persistence.SequenceGenerator;
import javax.persistence.GenerationType;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import java.util.List;
import java.util.Date;
import javax.validation.constraints.NotNull;
import javax.persistence.ManyToOne;

@Entity
@Data
@Table(name = "Purchaseoder")
public class Purchaseoder {
	@Id
	@SequenceGenerator(name="purchaseoder_seq",sequenceName="purchaseoder_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="purchaseoder_seq")
	@Column(name="idPurchaseoder")
	private @NonNull Long id;
	private  Date date;
	private  String numb;

	public Purchaseoder(){
    }

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Medicine.class)
    @JoinColumn(name = "IDMedicine")
    private  Medicine medicine;

    @ManyToOne(fetch = FetchType.LAZY,  targetEntity = Company.class)
    @JoinColumn(name = "IDCompany")
    private  Company company; 

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = ClinicStaff.class)
    @JoinColumn(name = "IDStaff")
    private  ClinicStaff clinicStaff;	

	public void setDate(Date date) {
		this.date = date;
	}

	public Date getDate(){
		return date;
	}

	public void setNumb(String numb){
		this.numb = numb;
	}

	public String getNumb(){
		return numb;
	}

	public void setMedicine(Medicine medicine){
		this.medicine=medicine;
	}
    public Medicine getMedicine() { 
    	return medicine; 
    }

    public void setCompany(Company company){
		this.company=company;
	}
    public Company getCompany() { 
    	return company; 
    }

    public void setClinicStaff(ClinicStaff clinicStaff){
		this.clinicStaff=clinicStaff;
	}
    public ClinicStaff getClinicStaff() { 
    	return clinicStaff; 
    }

	public Purchaseoder (Medicine medicine,Company company,Date date,String numb,
		  ClinicStaff clinicStaff){
	 		this.medicine = medicine;
			this.company = company;
			this.date = date;	 		
	 		this.numb = numb;
			this.clinicStaff = clinicStaff;
		}
}
