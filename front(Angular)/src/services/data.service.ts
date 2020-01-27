import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Producto } from 'src/interfaces/Producto';
import { Observable } from 'rxjs';
import { Inventario } from 'src/app/inventario';

@Injectable({
  providedIn: 'root'
})
export class DataService {

  ROOT_URL='http://localhost:8080/';
  constructor(private _http:HttpClient) { }

  addProduct (producto: Producto ): Observable<Producto> {
    return this._http.post<Producto>(this.ROOT_URL+"api-producto/producto", producto, httpOptions)     
  }
  
  addInventario (inventario: Inventario ): Observable<Inventario> {
    return this._http.post<Inventario>(this.ROOT_URL+"api-inventario/inventario", inventario, httpOptions)     
  }
}

const httpOptions = {
  headers: new HttpHeaders({
    'Content-Type':  'application/json',
  })
};
