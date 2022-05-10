import { Component, OnInit } from '@angular/core';
import { DomSanitizer } from '@angular/platform-browser';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  loginCss: string;

  constructor(public sanitizer: DomSanitizer) { 
    this.loginCss = '/assets/login.css';
  }

  ngOnInit(): void {
  }

}
