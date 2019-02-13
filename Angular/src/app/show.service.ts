import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class ShowService {

    public API = '//localhost:8080';


  constructor(private http: HttpClient) {}


 public  getMedicine() :  Observable<any>{
    return this.http.get(this.API+'/Medicine');
  }

 public  getClinicStaff() :  Observable<any>{
    return this.http.get(this.API+'/ClinicStaff');
  }
	
	public getCompany() :  Observable<any>{
    return this.http.get(this.API+'/Company');
  }

 


}
