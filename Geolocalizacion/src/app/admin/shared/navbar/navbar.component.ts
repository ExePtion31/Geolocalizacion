import { Component } from '@angular/core';

import { DataService } from '../../../services/data.service'
import { Router } from '@angular/router';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent {
  
  nombre: String | undefined;

  constructor(
    private router: Router,
    private dataService: DataService
  ) { 
    this.nombre = dataService.nombreUser;
  }

  logOut(): void {
    this.dataService.isLogged = false;
    this.router.navigate(['']);
  }
}
