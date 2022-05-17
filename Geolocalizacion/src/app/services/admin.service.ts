import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

import { Student, StudentCreate } from '../models/Student'

@Injectable({
  providedIn: 'root'
})
export class AdminService {

  adminURL: string = "http://localhost:8080/admin/"
  
  constructor(
    private httpClient: HttpClient
  ) { }

  public fetchUser(id: number): Observable<Student>{
    return this.httpClient.get<Student>(this.adminURL + `list/${id}`);
  }

  public listAll(): Observable<Student[]> {
    return this.httpClient.get<Student[]>(this.adminURL + 'list');
  }

  public saveUser(id:number, user:StudentCreate): Observable<any> {
    return this.httpClient.put<any>(this.adminURL + `update/${id}`, user);
  }

  public delete(id: number): Observable<any> {
    return this.httpClient.delete<any>(this.adminURL + `delete/${id}`);
  }
}
