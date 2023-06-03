import { Component, OnInit } from '@angular/core';
import { MongoService } from 'src/app/mongo.service';


@Component({
  selector: 'app-mongodb',
  templateUrl: './mongodb.component.html',
  styleUrls: ['./mongodb.component.css']
})


export class MongodbComponent implements OnInit {
  productos: any[] = [];
  producto = {
    id: null,
    categoria: '',
    nombre: '',
    precio: null,
    stock: null
  }

  public secciones: Array<string> = ['primera', 'segunda'];

  constructor(
    private mongoService: MongoService
  ){

  }

  ngOnInit(): void {
    this.getAll();
  }

  getAll(): void {
    this.mongoService.getAll()
      .subscribe( (data: any) => this.productos = data);
  }

  save(){
    if(this.producto.id){
      this.mongoService.update(this.producto.id!,this.producto)
      .subscribe(()=>this.getAll());
    }else{
      this.mongoService.create(this.producto)
      .subscribe(()=>this.getAll());
    }
    this.producto = {
      id: null,
      categoria: '',
      nombre: '',
      precio: null,
      stock: null
    }
  }

  edit(producto:any){
    this.producto = {
      ...producto
    };

  }

  delete(producto:any){
    this.mongoService.delete(producto.id)
      .subscribe(()=> this.getAll());
  }

}
