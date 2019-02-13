package com.sut.sa.g10;

import lombok.*;
import com.sut.sa.g10.entity.*;
import com.sut.sa.g10.repository.*;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import java.util.stream.Stream;
import java.util.Date;

@SpringBootApplication
@Data
public class CpeApplication {

    public static void main(String[] args) {
        SpringApplication.run(CpeApplication.class, args);
    }

	@Bean
	ApplicationRunner init(PurchaseoderRepository purchaseoderRepository,ClinicStaffRepository clinicStaffRepository,CompanyRepository companyRepository,MedicineRepository medicineRepository
	) {
		return args ->{

			ClinicStaff clinicStaff = new ClinicStaff();
			ClinicStaff clinicStaff1 = new ClinicStaff();
			ClinicStaff clinicStaff2 = new ClinicStaff();
			ClinicStaff clinicStaff3 = new ClinicStaff();
			ClinicStaff clinicStaff4 = new ClinicStaff();
			clinicStaff.setNameStaff("Marky Way");
			clinicStaff.setPassword("B02");
			clinicStaff1.setNameStaff("Minny Lua");
			clinicStaff1.setPassword("B03");
			clinicStaff2.setNameStaff("Edwyn Scar");
			clinicStaff2.setPassword("B04");
			clinicStaff3.setNameStaff("Edward Scar");
			clinicStaff3.setPassword("B05");
			clinicStaff4.setNameStaff("Eddy Scar");
			clinicStaff4.setPassword("B06");
			clinicStaffRepository.save(clinicStaff);
			clinicStaffRepository.save(clinicStaff1);
			clinicStaffRepository.save(clinicStaff2);
			clinicStaffRepository.save(clinicStaff3);
			clinicStaffRepository.save(clinicStaff4);

			Company company = new Company();
			Company company1 = new Company();
            company.setNameCompany("ABC");
            company.setAddress("249/14  Cola    ST.");            
            company.setPhone("044589762");
            company1.setNameCompany("XYZ");
            company1.setAddress("103/28  Pepzi  ST.");
            company1.setPhone("0658374031");            
            companyRepository.save(company);
            companyRepository.save(company1);

			Medicine medicine = new Medicine();
            Medicine medicine1 = new Medicine();
            Medicine medicine2 = new Medicine();
            Medicine medicine3 = new Medicine();
            Medicine medicine4 = new Medicine();
            medicine.setnameMedicine("Roxithromycin");
            medicine1.setnameMedicine("Metronidazole");
            medicine2.setnameMedicine("Paracetamol");
            medicine3.setnameMedicine("Ibuprofen");
            medicine4.setnameMedicine("Amoxicillin");
            medicineRepository.save(medicine);
            medicineRepository.save(medicine1);
            medicineRepository.save(medicine2);
            medicineRepository.save(medicine3);
            medicineRepository.save(medicine4);



			Purchaseoder purchaseoder = new Purchaseoder();
			purchaseoder.setMedicine(medicine);
			purchaseoder.setCompany(company);
			purchaseoder.setNumb("10");
			purchaseoder.setClinicStaff(clinicStaff);
			purchaseoderRepository.save(purchaseoder);
		};
	}

}