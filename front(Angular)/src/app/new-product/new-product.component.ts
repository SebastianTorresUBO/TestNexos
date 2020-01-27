import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, FormBuilder, Validators} from '@angular/forms';
import { HttpClient, HttpParams } from '@angular/common/http';
import { DataService } from '../../services/data.service';
import { Producto } from 'src/interfaces/Producto';
import { Observable } from 'rxjs';
import { Inventario } from '../inventario';

@Component({
  selector: 'app-new-product',
  templateUrl: './new-product.component.html',
  styleUrls: ['./new-product.component.css']
})
export class NewProductComponent implements OnInit {

  product: FormGroup;
  personaDto$: Producto[];
  inventarioDto$ : Inventario[];
  ArrayProducts: Observable<Producto[]>;
  readonly ROOT_URL='http://192.168.0.24:8080/';

  constructor(private dataService: DataService, private fb: FormBuilder, private http: HttpClient) { }

  ngOnInit() {
    this.product = this.fb.group({
      codigo: ['',Validators.required],
      nombre: ['',Validators.required],
      precio: ['',Validators.required]
   }),
   this.getProduct(),
   document.getElementById("roadToInventario").style.display="none";
   document.getElementById("updateInventario").style.display=" none";
  }


    getProduct(){
    
      this.ArrayProducts= this.http.get<Producto[]>(this.ROOT_URL +"api-producto/producto"); 
      console.log("holaaa"+this.ArrayProducts);
    }
    onSubmit() { 
      
      
    }

    createInventario(){
      debugger;
      var data: Inventario ={
        cod_producto: this.product.value.codigo ,
        stock: "0",
        precio: this.product.value.precio
     }
     console.log("PERROS"+JSON.stringify(data));
     document.getElementById("backButton").style.display="inline";
     alert("Inventario actualizado correctamente");
      return this.dataService.addInventario(data).subscribe(data=>this.inventarioDto$.push(data));
    
    }


    createProduct(){
      
      let product_ = new Producto();
      product_.cod_producto=this.product.value.codigo;
      product_.precio=this.product.value.precio;
      product_.stock="0";
      let productList_ : Array<Producto> = new Array;
      productList_.push(product_);
      
       var data: Producto ={
          id:this.product.value.codigo, 
          cod_producto: productList_ ,
          nombre: this.product.value.nombre,
          precio: this.product.value.precio,
          stock: "0",
       }
       console.log("HOLA MUNDO"+JSON.stringify(data));
       document.getElementById("updateInventario").style.display=" inline";
       document.getElementById("backButton").style.display="none";
       if((data.cod_producto!=null || data.cod_producto!=undefined) && data.nombre!=null && data.precio!=null){
         if(data.nombre!="" && data.precio!=""){
         alert("Producto: "+data.nombre+ " ingresado satisfactoriamente");
         return this.dataService.addProduct(data).subscribe(data=>this.personaDto$.push(data));
         } else{
          alert("No se ha logrado ingresar el producto correctamente");
         }
       } else{
         alert("No se ha logrado ingresar el producto correctamente");
       }
    }

}
