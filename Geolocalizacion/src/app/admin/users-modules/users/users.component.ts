import { Component, OnInit } from '@angular/core';

import { AdminService } from '../../../services/admin.service'
import { Student } from '../../../models/Student';
import { ToastrService } from 'ngx-toastr';

@Component({
  selector: 'app-users',
  templateUrl: './users.component.html',
  styleUrls: ['./users.component.css']
})
export class UsersComponent implements OnInit {

  users:any;

  constructor(
    private adminService: AdminService,
    private toaster: ToastrService,
  ) { }

  ngOnInit(): void {
    this.listAll();
  }

  listAll(): void {
    this.adminService.listAll().subscribe(
      (data:Student[]) => {
        this.users = data;
        this.toaster.success('Lista Cargada exitosamente', 'Exito',{
          timeOut:3000
        });
      },
      err => {
        this.toaster.error(err.error.message, 'Error',{
          timeOut:3000
        });
      } 
    )
  }

  borrar(id: number){
    this.adminService.delete(id).subscribe(
      data => {
        this.toaster.success(data.Message, 'Eliminado',{
          timeOut:3000
        });
        this.listAll();
      },
      err =>{
        this.toaster.error(err.error.mensaje, 'Error',{
          timeOut:3000
        });
      }
    )
  }
}
