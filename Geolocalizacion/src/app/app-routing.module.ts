import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { RegistroComponent } from './registro/registro.component'
import { HomeComponent } from './home/home.component'
import { UsuarioPrincipalComponent } from './student/usuario-principal/usuario-principal.component'
import { AdminPrincipalComponent } from './admin/admin-principal/admin-principal.component'
import { PerfilComponent } from './admin/perfil/perfil.component'
import { UsersComponent } from './admin/users-modules/users/users.component'
import { CreateComponent } from './admin/users-modules/create/create.component'
import { EditComponent } from './admin/users-modules/edit/edit.component'
import { CareersComponent } from './admin/careers-module/careers/careers.component'
import { EditCareersComponent } from './admin/careers-module/edit/edit.component'
import { CreateCareersComponent } from './admin/careers-module/create/create.component'
import { MapStudentComponent } from './student/map-student/map-student.component'
import { PerfilStudentComponent } from './student/perfil-student/perfil-student.component'
import { AuthGuard } from './guards/auth.guard';

const routes: Routes = [
  { path: '', component: HomeComponent },
  { path: 'registro', component: RegistroComponent },
  /* Admin Paths */
  { path: 'adminIndex', component: AdminPrincipalComponent, canActivate: [AuthGuard] },
  { path: 'perfil', component: PerfilComponent, canActivate: [AuthGuard] },
  /* Student paths */
  { path: 'userIndex', component: UsuarioPrincipalComponent, canActivate: [AuthGuard] },
  { path: 'perfil-student', component: PerfilStudentComponent, canActivate: [AuthGuard] },
  { path: 'map-student', component: MapStudentComponent, canActivate: [AuthGuard] },
  

  /* Users Paths*/
  { path: 'users', component: UsersComponent, canActivate: [AuthGuard] },
  { path: 'users/edit/:id', component: EditComponent, canActivate: [AuthGuard] },
  { path: 'users/new', component: CreateComponent, canActivate: [AuthGuard] },
  /* Careers Paths*/
  { path: 'careers', component: CareersComponent, canActivate: [AuthGuard] },
  { path: 'careers/edit/:id', component: EditCareersComponent, canActivate: [AuthGuard] },
  { path: 'careers/new', component: CreateCareersComponent, canActivate: [AuthGuard] }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
