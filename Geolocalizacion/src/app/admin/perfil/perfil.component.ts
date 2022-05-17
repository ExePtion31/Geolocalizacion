import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

import { Student, StudentCreate } from 'src/app/models/Student';
import { AdminService } from '../../services/admin.service'
import { ToastrService } from 'ngx-toastr';
import { DataService } from '../../services/data.service'

@Component({
  selector: 'app-perfil',
  templateUrl: './perfil.component.html',
  styleUrls: ['./perfil.component.css']
})
export class PerfilComponent implements OnInit {

  id: number = 0;
  user:any;
  nombre:string = "";
  correo:string = "";
  password:string = "";
  
  constructor(
    private adminService:AdminService,
    private toaster: ToastrService,
    private router: Router,
    private dataService: DataService
  ) { }

  ngOnInit(): void {
    this.id = this.dataService.idUser;
    this.fetchUser();
  }

  fetchUser(): void {
    this.adminService.fetchUser(this.id).subscribe(
      (data:Student) => {
        this.user = data;
      },
      err => {
        this.toaster.error(err.error.message, 'Error',{
          timeOut:3000
        });
      }
    )
  }

  saveUser(): void {
    const save = new StudentCreate(this.nombre.toUpperCase(), this.correo, this.password, this.user.jornada, this.user.carrera, this.user.rol);
    this.adminService.saveUser(this.id, save).subscribe(
      data => {
        this.toaster.success(data.message, 'Exito',{
          timeOut:3000
        });
        this.router.navigate(['/perfil', this.id]);
      },
      err => {
        this.toaster.error(err.error.message, 'Error',{
          timeOut:3000
        });
      }
    );
  }
}
