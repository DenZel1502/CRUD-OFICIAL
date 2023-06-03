import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import {FormsModule} from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';
import { HttpClientModule} from '@angular/common/http';
import { ReactiveFormsModule } from '@angular/forms';
//Login-Register
import { RegisterUserComponent } from './register-user/register-user.component';
import { LoginUserComponent } from './login-user/login-user.component';
//Componentes
import { AppComponent } from './app.component';
import { HomeComponent } from './components/home/home.component';
import { MongodbComponent } from './components/mongodb/mongodb.component';
import { MysqlComponent } from './components/mysql/mysql.component';
import { IntegrantesComponent } from './components/integrantes/integrantes.component';
import { PagenotfoundComponent } from './components/pagenotfound/pagenotfound.component';
import { NavmenuComponent } from './components/navmenu/navmenu.component';
import { CommonModule } from '@angular/common';
import { SqlService } from './sql.service';



@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    MongodbComponent,
    MysqlComponent,
    IntegrantesComponent,
    PagenotfoundComponent,
    NavmenuComponent,
    LoginUserComponent,
    RegisterUserComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    ReactiveFormsModule,
    CommonModule,
    
  ],
  providers: [SqlService],
  bootstrap: [AppComponent]
})
export class AppModule { }
