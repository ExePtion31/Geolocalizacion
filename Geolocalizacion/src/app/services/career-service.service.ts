import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Career, CareerCreate } from '../models/Career'

@Injectable({
  providedIn: 'root'
})
export class CareerService {

  careertURL = 'http://localhost:8080/career/';

  constructor(
    private httpClient:HttpClient
  ) { }

  //list careers
  public list(): Observable<Career[]>{
    return this.httpClient.get<Career[]>(this.careertURL + 'list');
  }

  public createCareer(career:CareerCreate): Observable<any>{
    return this.httpClient.post<any>(this.careertURL + 'create', career);
  }

  public delete(id: number): Observable<any> {
    return this.httpClient.delete<any>(this.careertURL + `delete/${id}`);
  }

  public fetchCareer(id: number): Observable<Career>{
    return this.httpClient.get<Career>(this.careertURL + `list/${id}`);
  }

  public saveCareer(id:number, carrera:CareerCreate): Observable<any> {
    return this.httpClient.put<any>(this.careertURL + `update/${id}`, carrera);
  }
}
