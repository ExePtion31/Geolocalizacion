import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-usuario-principal',
  templateUrl: './usuario-principal.component.html',
  styleUrls: ['./usuario-principal.component.css']
})
export class UsuarioPrincipalComponent implements OnInit {

  lat: number;
  long: number;
  zoom: number;
  mapTypeId: string;

  constructor() {
    this.lat = 40;
    this.long = -3;
    this.zoom = 6;
    this.mapTypeId = 'hybrid';
  }

  ngOnInit(): void {
  }

}
