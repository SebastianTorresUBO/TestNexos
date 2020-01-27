import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { FormRegistryComponent } from './form-registry/form-registry.component';
import { FormsModule,ReactiveFormsModule }   from '@angular/forms';
import { HttpClientModule} from '@angular/common/http';
import { QueryPeopleComponent } from './query-people/query-people.component';
import { DataService } from '../services/data.service';
import { SharedModule } from 'src/app/shared/shared.module';
import { NewProductComponent } from './new-product/new-product.component';








@NgModule({
  declarations: [
    AppComponent,
    FormRegistryComponent,
    QueryPeopleComponent,
    NewProductComponent,
    
    
    
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    ReactiveFormsModule,
    SharedModule
   
  ],
  providers: [DataService],
  bootstrap: [AppComponent]
})
export class AppModule { }
