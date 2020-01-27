import { Component, OnInit } from '@angular/core';

import { Persona } from 'src/classes/persona';
import { PersonaInt } from 'src/interfaces/Persona';
import { FormGroup, FormControl, FormBuilder, Validators} from '@angular/forms';
import { DataService } from '../../services/data.service';


@Component({
  selector: 'app-form-registry',
  templateUrl: './form-registry.component.html',
  styleUrls: ['./form-registry.component.css']
})
export class FormRegistryComponent implements OnInit {
  
  Persona: FormGroup;
  personaDto$: PersonaInt[];
  constructor(private dataService: DataService, private fb: FormBuilder) { }

  ngOnInit() {
    this.Persona = this.fb.group({
       nombres: ['',Validators.required],
       apellido: ['',Validators.required]
    })
  
    
  }

  model= new Persona('','','');
  submitted = false;

  onSubmit() { 
    console.log(this.Persona.value);
  }

  createPersons(){
    
    var data: PersonaInt={
      nombres: this.Persona.value.nombres,
      apellidos: this.Persona.value.apellido,
      procesado: false,
    }
    if(data.nombres!="" && data.apellidos!=""){
      alert("Dato ingresado satisfactoriamente");
    return this.dataService.addPerson(data).subscribe(data=>this.personaDto$.push(data));
    }
    
  }

  get diagnostic() { return JSON.stringify(this.model); }
}
