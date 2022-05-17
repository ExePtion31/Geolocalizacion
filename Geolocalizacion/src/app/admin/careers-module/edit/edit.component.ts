import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { Career, CareerCreate } from 'src/app/models/Career';
import { CareerService } from 'src/app/services/career-service.service';

@Component({
  selector: 'app-edit',
  templateUrl: './edit.component.html',
  styleUrls: ['./edit.component.css']
})
export class EditCareersComponent implements OnInit {

  career:any;
  facultad:string = "";
  carrera:string = "";
  id:number = 0;

  constructor(
    private rutaActiva: ActivatedRoute,
    private toaster: ToastrService,
    private router: Router,
    private careerService: CareerService
    ) { }

  ngOnInit(): void {
    this.id = this.rutaActiva.snapshot.params['id'];
    this.fetchCareer();
  }

  fetchCareer(): void {
    this.careerService.fetchCareer(this.id).subscribe(
      (data:Career) => {
        this.career = data;
      },
      err => {
        this.toaster.error(err.error.message, 'Error',{
          timeOut:3000
        });
      }
    )
  }

  saveCareer(): void {
    const save = new CareerCreate(this.carrera, this.facultad);
    this.careerService.saveCareer(this.id, save).subscribe(
      data => {
        this.toaster.success(data.message, 'Exito',{
          timeOut:3000
        });
        this.router.navigate(['/careers']);
      },
      err => {
        this.toaster.error(err.error.message, 'Error',{
          timeOut:3000
        });
      }
    );
  }
}
