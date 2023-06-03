import { NgModule } from '@angular/core';
import { RouterModule, Routes, ExtraOptions } from '@angular/router';
import { HomeComponent } from './components/home/home.component';
import { IntegrantesComponent } from './components/integrantes/integrantes.component';
import { LoginUserComponent } from './login-user/login-user.component';
import { MongodbComponent } from './components/mongodb/mongodb.component';
import { MysqlComponent } from './components/mysql/mysql.component';
import { NavmenuComponent } from './components/navmenu/navmenu.component';
import { PagenotfoundComponent } from './components/pagenotfound/pagenotfound.component';
import { RegisterUserComponent } from './register-user/register-user.component';

//Rutas de navegazzzzion
const routes: Routes = [
  {path: '', redirectTo: '/home', pathMatch:'full'},
  {path: 'home', component: HomeComponent},
  {path: 'mongodb', component: MongodbComponent},
  {path: 'mysql', component: MysqlComponent},
  {path: 'integrantes', component: IntegrantesComponent},
  {path: '**', component: PagenotfoundComponent},
  {path: 'navmenu', component:NavmenuComponent},
  {path: 'login', component:LoginUserComponent},
  {path: 'register', component:RegisterUserComponent}
  
];

const routerOptions: ExtraOptions = {
  anchorScrolling: "enabled",
  scrollPositionRestoration: 'enabled'
}

@NgModule({
  imports: [RouterModule.forRoot(routes,routerOptions)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
