package com.sut.sa.g10.cotroller;

import com.sut.sa.g10.entity.*;
import com.sut.sa.g10.repository.*;
import lombok.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import java.util.Collection;
import java.util.stream.Collectors;
import java.util.Date;
import java.util.Optional;


@RestController 
@CrossOrigin(origins = "http://localhost:4200")
public class PurchaseoderController {
    @Autowired
    private PurchaseoderRepository purchaseoderRepository;
    @Autowired
    private ClinicStaffRepository clinicStaffRepository;
    @Autowired
    private CompanyRepository companyRepository;
    @Autowired
    private MedicineRepository medicineRepository;
    
     /////เพิ่มล๊อกอิน

    @GetMapping("/ClinicStaff/{nameStaff}/{password}")
    public boolean customer1(@PathVariable String nameStaff, @PathVariable String password) {
        ClinicStaff user = clinicStaffRepository.findByNameStaff(nameStaff);
        String x = user.getPassword();
        //System.out.println(nameStaff);
        //System.out.println(x + " = " + password);
        return x.matches(password);
    }


    @GetMapping(path = "Purchaseoder", produces = MediaType.APPLICATION_JSON_VALUE)
    public Collection<Purchaseoder> Purchaseoder() {
        return purchaseoderRepository.findAll().stream().collect(Collectors.toList());
    }
    @GetMapping("/Purchaseoder/{id}")
    public Optional<Purchaseoder> purchaseoder(@PathVariable Long id) {
        Optional<Purchaseoder> a = purchaseoderRepository.findById(id);
        return a;
    }

    @GetMapping(path = "Medicine", produces = MediaType.APPLICATION_JSON_VALUE)
    public Collection<Medicine> Medicine() {
        return medicineRepository.findAll().stream().collect(Collectors.toList());
    }
    
     @GetMapping("/Medicine/{id}")
    public Optional<Medicine> medicine(@PathVariable Long id)  {
        Optional<Medicine> pa = medicineRepository.findById(id);
        return pa;
    }

    @GetMapping(path = "Company", produces = MediaType.APPLICATION_JSON_VALUE)
    public Collection<Company> Company() {
        return companyRepository.findAll().stream().collect(Collectors.toList());
    }
    
    @GetMapping("/Company/{id}")
    public Optional<Company> company(@PathVariable Long id) {
        Optional<Company> d = companyRepository.findById(id);
        return d;
    }
  


    @GetMapping(path = "ClinicStaff", produces = MediaType.APPLICATION_JSON_VALUE)
    public Collection<ClinicStaff> ClinicStaff() {
        return clinicStaffRepository.findAll().stream().collect(Collectors.toList());
    }
    
    @GetMapping("/ClinicStaff/{id}")
    public Optional<ClinicStaff> clinicStaff(@PathVariable Long id) {
        Optional<ClinicStaff> c = clinicStaffRepository.findById(id);
        return c;
    }

    @PostMapping(path ="/Purchaseoder/{nameMedicineSelect}/{nameCompanySelect}/{date}/{numb}/{nameStaffSelect}")
    @CrossOrigin(origins = "http://localhost:4200")
    public Purchaseoder purchaseoder(
                                            @PathVariable  Long nameMedicineSelect,
                                            @PathVariable  Long nameCompanySelect,
                                            @PathVariable  Date date,                                           
                                            @PathVariable  String numb,
                                            @PathVariable  Long nameStaffSelect){


            Medicine medicine = medicineRepository.findById(nameMedicineSelect).get();
            Company company = companyRepository.findById(nameCompanySelect).get();            
            ClinicStaff clinicStaff = clinicStaffRepository.findById(nameStaffSelect).get();
        
        Purchaseoder purchaseoder = new Purchaseoder();
        purchaseoder.setMedicine(medicine);
        purchaseoder.setCompany(company);
        purchaseoder.setDate(date);        
        purchaseoder.setNumb(numb);
        purchaseoder.setClinicStaff(clinicStaff);

        purchaseoderRepository.save(purchaseoder);
        return purchaseoder;
    } 
}