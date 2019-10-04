import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HttpClientModule } from '@angular/common/http';

import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { SharedModule } from 'src/app/shared/shared.module';
import { VacinaRoutingModule } from './vacina-routing.module';
import { VacinaComponent } from './vacina-list/vacina.component';
import { VacinaFormComponent } from './vacina-form/vacina-form.component';
 

@NgModule({
  declarations: [
    VacinaComponent, 
    VacinaFormComponent
  ],
  imports: [
    CommonModule,
    VacinaRoutingModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule,
    SharedModule
  ]
})
export class VacinaModule { }
