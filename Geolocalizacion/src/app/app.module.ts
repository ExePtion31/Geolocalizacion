import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { FormsModule } from '@angular/forms';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http'

import { ToastrModule } from 'ngx-toastr';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';

import { HeaderModule } from './shared/components/header/header.module';
import { FooterModule } from './shared/components/footer/footer.module';
import { SpinnerModule } from './shared/components/spinner/spinner.module'
import { UsuarioPrincipalComponent } from './usuario-principal/usuario-principal.component';
import { RegistroComponent } from './registro/registro.component';
import { HomeComponent } from './home/home.component';
import { SpinnerInterceptor } from './shared/intercerptors/spinner.intercerptor';

@NgModule({
  declarations: [
    AppComponent,
    RegistroComponent,
    HomeComponent,
    UsuarioPrincipalComponent
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    ToastrModule.forRoot(),
    SpinnerModule,
    HeaderModule,
    FooterModule
  ],
  providers: [
    { 
      provide: HTTP_INTERCEPTORS, useClass: SpinnerInterceptor, multi: true 
    }
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
