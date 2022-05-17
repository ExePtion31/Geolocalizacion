import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { CareerCreate } from 'src/app/models/Career';
import { CareerService } from 'src/app/services/career-service.service';

@Component({
  selector: 'app-create',
  templateUrl: './create.component.html',
  styleUrls: ['./create.component.css']
})
export class CreateCareersComponent implements OnInit{

  carrera:string = "";
  facultad:string = "";

  constructor(
    private careerService: CareerService,
    private toastr: ToastrService,
    private router: Router
  ) { }

  ngOnInit(): void {
    
  }

  onRegister():void {
    const career = new CareerCreate(this.carrera.toUpperCase(), this.facultad.toUpperCase());
    this.careerService.createCareer(career).subscribe(
      data => {
        this.toastr.success(data.message, 'Exito',{
          timeOut:3000
        });
        this.router.navigate(['/careers']);
      },
      err => {
        this.toastr.error(err.error.message, 'Error',{
          timeOut:3000
        });
      }
    );
  }
}
