import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { StudentCreate } from '../models/Student'
import { requestLogin } from '../models/requestLogin'

@Injectable({
  providedIn: 'root'
})
export class StudentServiceService {

  studentURL = 'http://localhost:8080/students/';

  constructor(
    private httpClient:HttpClient
  ) { }

  //fetchUser student
  public fetchUser(request: requestLogin): Observable<any>{
    return this.httpClient.post<any>(this.studentURL + 'validation/login', request);
  }

  //create student
  public createStudent(student: StudentCreate): Observable<any> {
    return this.httpClient.post<any>(this.studentURL + 'create', student);
  }
}
