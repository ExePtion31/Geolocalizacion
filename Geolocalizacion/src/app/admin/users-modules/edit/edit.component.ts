import { Component, OnInit } from '@angular/core';
import { AdminService } from '../../../services/admin.service';
import { CareerService } from '../../../services/career-service.service';
import { ActivatedRoute, Router } from '@angular/router';
import { Student, StudentCreate } from '../../../models/Student'
import { Career } from '../../../models/Career'
import { ToastrService } from 'ngx-toastr';

@Component({
  selector: 'app-edit',
  templateUrl: './edit.component.html',
  styleUrls: ['./edit.component.css']
})
export class EditComponent implements OnInit {

  id: number = 0;
  careersArray:Career[] = [];
  user:any;
  nombre:string = "";
  correo:string = "";
  password:string = "";
  jornada:string = "";
  rol:number = 3;
  carrera:string = "";

  constructor(
    private adminService: AdminService,
    private rutaActiva: ActivatedRoute,
    private toaster: ToastrService,
    private router: Router,
    private careerService: CareerService
  ) { }

  ngOnInit(): void {
    this.id = this.rutaActiva.snapshot.params['id'];
    this.fetchUser();
    this.onList();
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

  onList() : void {
    this.careerService.list().subscribe(
      (data:Career[]) => {
        this.careersArray = data;
      },
      err => {
        console.log(err);
        this.toaster.error(err.error.message, 'Error',{
          timeOut:3000
        });
      }
    );
  }

  saveUser(): void {
    const save = new StudentCreate(this.nombre.toUpperCase(), this.correo, this.password, this.jornada, this.carrera, this.rol);
    this.adminService.saveUser(this.id, save).subscribe(
      data => {
        this.toaster.success(data.message, 'Exito',{
          timeOut:3000
        });
        this.router.navigate(['/users']);
      },
      err => {
        this.toaster.error(err.error.message, 'Error',{
          timeOut:3000
        });
      }
    );
  }
}
