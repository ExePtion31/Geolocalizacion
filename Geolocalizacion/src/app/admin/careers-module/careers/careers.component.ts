import { Component, OnInit } from '@angular/core';
import { CareerService } from '../../../services/career-service.service'
import { Career } from '../../../models/Career';
import { ToastrService } from 'ngx-toastr';

@Component({
  selector: 'app-careers',
  templateUrl: './careers.component.html',
  styleUrls: ['./careers.component.css']
})
export class CareersComponent implements OnInit {
  carreras: any;

  constructor(
    private careerService: CareerService,
    private toaster: ToastrService
  ) { }

  ngOnInit(): void {
    this.listAll();
  }

  listAll(): void {
    this.careerService.list().subscribe(
      (data:any) => {
        this.carreras = data;
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
    this.careerService.delete(id).subscribe(
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
