import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { BrowserModule } from '@angular/platform-browser';
import { FilterPipe } from 'src/app/filter.pipe';



@NgModule({
  imports: [
    // Modules
    BrowserModule
  ],

  declarations: [
    // Components &amp; directives
    FilterPipe
  ],

  providers: [
    // Services
  ],

  exports: [
    // ...
    FilterPipe
  ]
})
export class SharedModule { }
