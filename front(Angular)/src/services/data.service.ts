import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { PersonaInt } from 'src/interfaces/Persona';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class DataService {

  ROOT_URL='http://localhost:8080/api-personas/personas';
  constructor(private _http:HttpClient) { }

  addPerson (persona: PersonaInt ): Observable<PersonaInt> {
    return this._http.post<PersonaInt>(this.ROOT_URL, persona, httpOptions)     
}
  
}

const httpOptions = {
  headers: new HttpHeaders({
    'Content-Type':  'application/json',
  })
};
