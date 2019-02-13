import { Component, OnInit } from '@angular/core';
import { ShowService } from '../show.service';
import {HttpClient} from '@angular/common/http';



@Component({
  selector: 'app-purchaseoder',
  templateUrl: './purchaseoder.component.html',
  styleUrls: ['./purchaseoder.component.css']
})
export class PurchaseoderComponent implements OnInit {


  	nameMedicine: Array<any>;
  	nameMedicineSelect='';

  	nameStaff: Array<any>;
  	nameStaffSelect='';

  	nameCompany: Array<any>;
    nameCompanySelect='';

    
  	numb='';
  	date='';
	constructor(private app : ShowService, private httpClient: HttpClient) { }

  

  ngOnInit() {
  	this.app.getMedicine().subscribe(data=>{
          this.nameMedicine =  data;
          console.log(this.nameMedicine);
      })

  	this.app.getClinicStaff().subscribe(data=>{
          this.nameStaff =  data;
          console.log(this.nameStaff);
      })
	  this.app.getCompany().subscribe(data=>{
          this.nameCompany =  data;
          console.log(this.nameCompany);
      })

    
    }

    save() {

    if (this.nameMedicineSelect === '' || this.nameCompanySelect === ''  || this.date === '' 
    ||this.numb === '' || this.nameStaffSelect === '') {
      alert('กรอกข้อมูลให้ครบถ้วน');
      } else {

    this.httpClient.post('http://localhost:8080/Purchaseoder/' + this.nameMedicineSelect + '/' + this.nameCompanySelect + '/' + this.date +'/'+ this.numb +'/' + this.nameStaffSelect,{})
     .subscribe(
       data => {
         console.log('PUT Request is successful', data);
        },
        error => {
          console.log('Error', error);
        }
      );
       alert('บันทึกข้อมูลเรียบร้อย');
  }}
}
