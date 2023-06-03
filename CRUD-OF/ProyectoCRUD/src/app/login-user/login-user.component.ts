import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { LoginuserService } from 'src/app/loginuser.service';
import { User } from 'src/app/user';

@Component({
  selector: 'app-login-user',
  templateUrl: './login-user.component.html',
  styleUrls: ['./login-user.component.css']
})
export class LoginUserComponent implements OnInit {

  user:User =new User();

  constructor(private loginuserservice: LoginuserService, public router:Router) { }

  ngOnInit(): void {
  }
  
  userLogin(){
    console.log(this.user)
    this.loginuserservice.loginUser(this.user).subscribe(_data=>{
      alert("Inicio sesión con exito!");
      this.router.navigateByUrl('mongodb');
    },_error=>alert("Ingrese clave y usuario correctos..."));
  }
}
