import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

const API_BASE = 'http://localhost:8089';

@Injectable({
  providedIn: 'root'
})
export class MongoService {

  constructor(
    private http:HttpClient
  ) { }

  getAll(){
    return this.http.get(`${API_BASE}/productos`);
  }

  create(producto: any){
    return this.http.post(`${API_BASE}/productos`, producto);
  }

  update(id: string, producto: any) {
    return this.http.put(`${API_BASE}/productos/${id}`, producto);
  }

  delete(id: string) {
    return this.http.delete(`${API_BASE}/productos/${id}`);
  }
}
