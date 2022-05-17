import { Component, OnInit } from '@angular/core';
import { StudentServiceService } from '../services/student-service.service';
import { CareerService } from '../services/career-service.service';
import { ToastrService } from 'ngx-toastr';
import { StudentCreate } from '../models/Student';
import { Career } from '../models/Career';
import { Router } from '@angular/router';

@Component({
  selector: 'app-registro',
  templateUrl: './registro.component.html',
  styleUrls: ['./registro.component.css']
})
export class RegistroComponent implements OnInit {

  careersArray:Career[] = [];

  nombre:string = '';
  correo:string = '';
  password:string = '';
  jornada:string = '';
  carrera:string = '';


  constructor(
    private studentService: StudentServiceService,
    private careerService: CareerService,
    private toastr: ToastrService,
    private router: Router
  ) { }

  ngOnInit(): void {
    this.onList();
  }

  onList() : void {
    this.careerService.list().subscribe(
      (data:Career[]) => {
        this.careersArray = data;
      },
      err => {
        console.log(err);
        this.toastr.warning(err.error.message, 'Error',{
          timeOut:3000
        });
      }
    );
  }

  onRegister():void {
    const student = new StudentCreate(this.nombre.toUpperCase(), this.correo, this.password, this.jornada, this.carrera, 1);
    this.studentService.createStudent(student).subscribe(
      data => {
        this.toastr.success(data.message, 'Exito',{
          timeOut:3000
        });
        this.router.navigate(['/']);
      },
      err => {
        this.toastr.error(err.error.message, 'Error',{
          timeOut:3000
        });
      }
    );
  }

}
