import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { VacinaComponent } from './vacina-list/vacina.component';
import { VacinaFormComponent } from './vacina-form/vacina-form.component';

const routes: Routes = [
  { path: '', component: VacinaComponent },
  { path: 'new', component: VacinaFormComponent },
  { path: ':id/edit', component: VacinaFormComponent }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class VacinaRoutingModule { }
