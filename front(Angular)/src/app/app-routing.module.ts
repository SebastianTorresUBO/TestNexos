import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { FormRegistryComponent } from './form-registry/form-registry.component';
import { QueryPeopleComponent } from './query-people/query-people.component';


const routes: Routes = [
  { path: 'person-registry', component: FormRegistryComponent },
  { path: 'person-query', component: QueryPeopleComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
