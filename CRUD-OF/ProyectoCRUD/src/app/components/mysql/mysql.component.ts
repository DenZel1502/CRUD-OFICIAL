import { Component, OnInit } from '@angular/core';
import { SqlService } from 'src/app/sql.service';
import { Cliente } from 'src/app/Cliente';

@Component({
  selector: 'app-mysql',
  templateUrl: './mysql.component.html',
  styleUrls: ['./mysql.component.css']
})
export class MysqlComponent implements OnInit {

  clientes :Cliente[]=[];
  constructor(
    private sqlService: SqlService
  ) { }

  ngOnInit(): void {
    this.sqlService.lista()
      .subscribe(response => this.clientes = response);
  }

  savePlsql(){}

}
