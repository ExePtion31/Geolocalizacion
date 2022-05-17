import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { Career } from 'src/app/models/Career';
import { StudentCreate } from 'src/app/models/Student';
import { CareerService } from 'src/app/services/career-service.service';
import { StudentServiceService } from 'src/app/services/student-service.service';

@Component({
  selector: 'app-create',
  templateUrl: './create.component.html',
  styleUrls: ['./create.component.css']
})
export class CreateComponent implements OnInit {

  careersArray:Career[] = [];

  nombre:string = '';
  correo:string = '';
  password:string = '';
  jornada:string = '';
  carrera:string = '';
  rol: number = 3;

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
    const student = new StudentCreate(this.nombre.toUpperCase(), this.correo, this.password, this.jornada, this.carrera, this.rol);
    this.studentService.createStudent(student).subscribe(
      data => {
        this.toastr.success(data.message, 'Exito',{
          timeOut:3000
        });
        this.router.navigate(['/users']);
      },
      err => {
        this.toastr.error(err.error.message, 'Error',{
          timeOut:3000
        });
      }
    );
  }
}
