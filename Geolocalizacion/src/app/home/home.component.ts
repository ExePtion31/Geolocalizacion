import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

import { ToastrService } from 'ngx-toastr';
import { StudentServiceService } from '../services/student-service.service';
import { requestLogin } from '../models/requestLogin';
import { DataService } from '../services/data.service'

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  correo: string = '';
  password: string = '';

  constructor(
    private studentService: StudentServiceService,
    private toastr: ToastrService,
    private router: Router,
    private dataService: DataService
  ) { }

  ngOnInit(): void {
  }

  onValidate(): void {
    const request = new requestLogin(this.correo, this.password);
    this.studentService.validateUser(request).subscribe(
      data => {
        this.toastr.success('', 'Exito', {
          timeOut: 3000
        });

        this.dataService.isLogged = true;
        this.dataService.idUser = data.id;
        this.dataService.nombreUser = data.nombre;
        this.dataService.rolUser = data.role;

        if (data.role === 0) {
          this.router.navigate(['adminIndex']);
        } else if (data.role === 1) {
          this.router.navigate(['userIndex']);
        }
      },
      err => {
        this.toastr.error(err.error.message, 'Error', {
          timeOut: 3000
        });
      }
    );
  }

}
