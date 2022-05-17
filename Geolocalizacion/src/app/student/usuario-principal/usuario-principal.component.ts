import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-usuario-principal',
  templateUrl: './usuario-principal.component.html',
  styleUrls: ['./usuario-principal.component.css']
})
export class UsuarioPrincipalComponent {

  constructor(
    private route: ActivatedRoute
  ) {}
}
