import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Cliente } from './Cliente';
import { Observable, throwError } from 'rxjs';
import { catchError,retry } from 'rxjs/operators';


@Injectable()
export class SqlService {

  constructor(private http:HttpClient) { }

  Url: String=  'http://localhost:8088/cliente';

  lista():Observable<Cliente[]>{
    return this.http.get<Cliente[]>(this.Url+'/lista');
  }

  crearCliente(cliente: Cliente): Observable<Cliente> {
    return this.http.post<Cliente>(this.Url + '/crear', cliente);
  }

  obtenerCliente(id: number): Observable<Cliente> {
    return this.http.get<Cliente>(this.Url + '/obtener/' + id);
  }

  actualizarCliente(cliente: Cliente): Observable<Cliente> {
    return this.http.put<Cliente>(this.Url + '/actualizar/' + cliente.id, cliente);
  }

  eliminarCliente(id: number): Observable<any> {
    return this.http.delete(this.Url + '/eliminar/' + id);
  }

  
}
