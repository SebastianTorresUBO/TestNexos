import { Component, OnInit } from '@angular/core';

import { Persona } from 'src/classes/persona';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Producto } from 'src/interfaces/Producto';
import { FormGroup, FormControl, FormBuilder, Validators} from '@angular/forms';
import { DataService } from '../../services/data.service';
import { Observable } from 'rxjs';


@Component({
  selector: 'app-form-registry',
  templateUrl: './form-registry.component.html',
  styleUrls: ['./form-registry.component.css']
})
export class FormRegistryComponent implements OnInit {
  
  Persona: FormGroup;
  personaDto$: Producto[];
  readonly ROOT_URL='http://192.168.0.24:8080/';
  ArrayProducts: Observable<Producto[]>;
  searchString: string;

  constructor(private dataService: DataService, private fb: FormBuilder, private http: HttpClient) { }

  ngOnInit() {
    this.Persona = this.fb.group({
       nombres: ['',Validators.required],
       apellido: ['',Validators.required]
    })
    this.getProduct();
  
    
  }

  getProduct(){
    
    this.ArrayProducts= this.http.get<Producto[]>(this.ROOT_URL +"api-producto/producto"); 
    
    console.log(this.ArrayProducts);
  }

  onSubmit() { 
    console.log(this.Persona.value);
  }

   updateInventario(object: Producto): Observable<Producto> {
     
    console.log(object);
    return this.http.put<Producto>(this.ROOT_URL+"api-producto/producto/"+object.id, object);
    
  }

  captureValue(object1:Producto,object2: Producto){
    debugger;
    let stock =Number(object2.stock)+1;
    object2.stock=stock.toString();
   
    var data: Producto ={
        id:object1.id,
        cod_producto:object1.cod_producto,
        nombre:object1.nombre,
        precio:object1.precio,
        stock:object1.stock,
    }
    confirm("¿Desea agregar el producto al inventario?");
    alert("Producto: "+data.nombre + " agregado al inventario satisfactoriamente");
    return this.updateInventario(data).subscribe(data=>this.personaDto$.push(data));
  }

  sellProduct(object1:Producto,object2: Producto){
    
    
      let stock =Number(object2.stock)-1;
      if(stock>=0){
      object2.stock=stock.toString();
    
      var data: Producto ={
          id:object1.id,
          cod_producto:object1.cod_producto,
          nombre:object1.nombre,
          precio:object1.precio,
          stock:object1.stock,
      }
      
      alert("Venta de producto: "+data.nombre+" realizada");
      return this.updateInventario(data).subscribe(data=>this.personaDto$.push(data));
     } else{
       alert("No se puede realizar ventas, no hay stock en el inventario");
     }
  }
  createPersons(){
    
  }


}
