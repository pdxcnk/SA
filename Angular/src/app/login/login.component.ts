import { Component, OnInit } from '@angular/core';
import { ShowService } from '../show.service';
import {HttpClient} from '@angular/common/http';
import {Router} from '@angular/router';


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  ClinicStaff: any ={
    nameStaff:'',
    password:''
  }

  check:any =''
  
  constructor(private app : ShowService, private httpClient: HttpClient, private router:Router) { }


    ngOnInit() {

    }
    
    login(){
    if (this.ClinicStaff.nameStaff === '' || this.ClinicStaff.password === '') {
      alert('กรุณากรอกข้อมูลให้ครบถ้วน');
    } else {
      this.httpClient.get('http://localhost:8080/ClinicStaff/' + this.ClinicStaff.nameStaff + '/' + this.ClinicStaff.password,this.ClinicStaff)
      .subscribe(
        data =>   {
          this.check = data;
          console.log('PUT Request is successful', data);
          if (this.check === true) {
            // alert('login sucessful');
            this.router.navigate(['purchaseoder',{
              }]);
          } else {
            alert('username หรือ password ของท่านไม่ถูกต้อง กรุณา login ใหม่');
          }
        },
        error =>  {
          console.log('Error', error);
        }
      );
    }

  }

}