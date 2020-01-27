import { Component, OnInit } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Observable } from 'rxjs';

import { DataQueryForm } from 'src/interfaces/DataQueryForm';
import { FormGroup, FormControl } from '@angular/forms';


@Component({
  selector: 'app-query-people',
  templateUrl: './query-people.component.html',
  styleUrls: ['./query-people.component.css']
})
export class QueryPeopleComponent implements OnInit {
  
  readonly ROOT_URL='http://localhost:8080/api-venta/venta';
  //ArrayVenta: Observable<Venta[]>;
  searchString: string;
  //personaDto$: PersonaInt[];


  constructor(private http: HttpClient) { }

  ngOnInit() {
    this.getPersons();
  }

  getPersons(){
   // this.ArrayVenta= this.http.get<Venta[]>(this.ROOT_URL ); 
  }

  /*updatePerson(object: PersonaInt): Observable<PersonaInt> {
    console.log(object);
    return this.http.put<PersonaInt>(this.ROOT_URL+"/"+object.id, object);
  }*/

  /*captureValue(object: PersonaInt){

    object.procesado=true;
    return this.updatePerson(object).subscribe(object=>this.personaDto$.push(object));
  }*/

  onSubmit() { 
    
  }



}
