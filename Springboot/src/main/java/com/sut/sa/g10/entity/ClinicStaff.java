package com.sut.sa.g10.entity;
import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.GenerationType;
import javax.validation.constraints.NotNull;
import lombok.*;
@Entity
@Data
@Table(name = "ClinicStaff")

public class ClinicStaff {
    @Id
    @SequenceGenerator(name="clinicStaff_seq",sequenceName="clinicStaff_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="clinicStaff_seq")
    @Column(name="IdStaff")
    private @NotNull Long id;
    private @NotNull String nameStaff;
    private String password;

    public ClinicStaff(){}
    public ClinicStaff(Long id,String nameStaff,String password) {
        this.nameStaff = nameStaff;
        this.password = password;
    }

    public void setNameStaff(String nameStaff){
        this.nameStaff = nameStaff;
    }
    public String getNameStaff(){
        return nameStaff;
    }

    public void setPassword(String password){
        this.password = password;
    }
    public String getPassword(){
        return password;
    }
}

