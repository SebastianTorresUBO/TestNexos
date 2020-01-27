import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { FormRegistryComponent } from './form-registry/form-registry.component';
import { QueryPeopleComponent } from './query-people/query-people.component';
import { NewProductComponent } from './new-product/new-product.component';



const routes: Routes = [
  { path: 'inventario-registry', component: FormRegistryComponent },
  { path: 'person-query', component: QueryPeopleComponent },
  { path: 'new-product', component: NewProductComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
