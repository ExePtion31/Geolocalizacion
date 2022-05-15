import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Career } from '../models/Career'
import { requestLogin } from '../models/requestLogin'

@Injectable({
  providedIn: 'root'
})
export class CareerServiceService {

  careertURL = 'http://localhost:8080/career/';

  constructor(
    private httpClient:HttpClient
  ) { }

  //list careers
  public list(): Observable<Career[]>{
    return this.httpClient.get<Career[]>(this.careertURL + 'list');
  }
}
