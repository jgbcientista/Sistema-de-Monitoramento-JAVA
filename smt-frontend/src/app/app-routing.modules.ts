import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomeComponent } from './pages/home/home.component';

const routes: Routes = [
    { path: '', component: HomeComponent },
    { path: 'categorias', loadChildren: './pages/categoria/categoria.module#CategoriaModule' },
    { path: 'vacinas', loadChildren: './pages/vacina/vacina.module#VacinaModule' },

];

@NgModule({
    declarations: [],
    imports: [RouterModule.forRoot(routes)],
    exports: [RouterModule]
})
export class AppRoutingModule { }
