import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ReactiveFormsModule } from "@angular/forms";
import { RouterModule } from "@angular/router";
import { PageHeaderComponent } from './components/page-header/page-header.component';
import {DropdownModule} from 'primeng/dropdown';
import {TableModule} from 'primeng/table';

@NgModule({
  imports: [
    CommonModule,
    ReactiveFormsModule,
    RouterModule,
    DropdownModule,
    TableModule
  ],
  declarations: [PageHeaderComponent],
  exports: [
    // shared modules
    CommonModule,
    ReactiveFormsModule,
    RouterModule,
    PageHeaderComponent,
    DropdownModule,
    TableModule
  ]
})
export class SharedModule { }