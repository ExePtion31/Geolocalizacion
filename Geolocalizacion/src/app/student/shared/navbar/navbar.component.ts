import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { DataService } from 'src/app/services/data.service';

@Component({
  selector: 'app-navbar-student',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarStudentComponent implements OnInit {

  nombre: String | undefined;

  constructor(
    private router: Router,
    private dataService: DataService
    ) { 
      this.nombre = dataService.nombreUser;
    }

  ngOnInit(): void {
  }

  logOut(): void {
    this.dataService.isLogged = false;
    this.router.navigate(['']);
  }
}
