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
import { UsuarioPrincipalComponent } from './student/usuario-principal/usuario-principal.component';
import { RegistroComponent } from './registro/registro.component';
import { HomeComponent } from './home/home.component';
import { SpinnerInterceptor } from './shared/intercerptors/spinner.intercerptor';
import { AdminPrincipalComponent } from './admin/admin-principal/admin-principal.component';
import { NavbarComponent } from './admin/shared/navbar/navbar.component';
import { PerfilComponent } from './admin/perfil/perfil.component';
import { UsersComponent } from './admin/users-modules/users/users.component';
import { CreateComponent } from './admin/users-modules/create/create.component';
import { EditComponent } from './admin/users-modules/edit/edit.component';
import { CareersComponent } from './admin/careers-module/careers/careers.component';
import { CreateCareersComponent } from './admin/careers-module/create/create.component'
import { EditCareersComponent } from './admin/careers-module/edit/edit.component'
import { NavbarStudentComponent } from './student/shared/navbar/navbar.component';
import { PerfilStudentComponent } from './student/perfil-student/perfil-student.component';
import { MapStudentComponent } from './student/map-student/map-student.component'

@NgModule({
  declarations: [
    AppComponent,
    RegistroComponent,
    HomeComponent,
    NavbarComponent,
    UsuarioPrincipalComponent,
    AdminPrincipalComponent,
    PerfilComponent,
    UsersComponent,
    CreateComponent,
    EditComponent,
    CareersComponent,
    CreateCareersComponent,
    EditCareersComponent,
    NavbarStudentComponent,
    PerfilStudentComponent,
    MapStudentComponent
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
