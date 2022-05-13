import { Component, OnInit } from '@angular/core';
import { requestLogin } from '../models/requestLogin';
import { ToastrService } from 'ngx-toastr';
import { StudentServiceService } from '../services/student-service.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  correo:string = '';
  password:string = '';

  constructor(
    private studentService: StudentServiceService,
    private toastr: ToastrService,
    private router: Router
  ) {}

  ngOnInit(): void {
  }

  onValidate():void{
    const request = new requestLogin(this.correo, this.password);
    this.studentService.fetchUser(request).subscribe(
      data => {
        this.toastr.success('', 'Exito',{
          timeOut:3000
        });
        if(data.role === 1){
          this.router.navigate(['userIndex', data.id]);
        }
      },
      err => {
        console.log(err);
        this.toastr.error(err.error.message, 'Error',{
          timeOut:3000
        });
      }
    );
  }

}
