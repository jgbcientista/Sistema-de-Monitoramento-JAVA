import { Component, OnInit } from '@angular/core';
import { Categoria } from '../categoria.model';
import { CategoriaService } from '../categoria.service';
import toastr from "toastr";
import { getAllDebugNodes } from '@angular/core/src/debug/debug_node';

@Component({
    selector: 'bill-categoria',
    templateUrl: './categoria.component.html',
    styleUrls: ['./categoria.component.css']
})
export class CategoriaComponent implements OnInit {

    categorias: Categoria[] = [];

    constructor(private categoriaService: CategoriaService) { }

    ngOnInit() {
        // this.categoriaService.getAll().subscribe(
        //     categorias => { this.categorias = categorias },
        //     error => alert('Erro ao carregar a lista')
        // );

        this.getAll();
    }

    getAll() {
        // this.categoriaService.getAll().subscribe(
        //     categorias => {
        //         Object.values(categorias).map(v => Object.assign(this.categorias, v));
        //     },
        //     error => toastr.error(`Erro ao carregar a lista! ${error}`)
        // );

        this.categoriaService.getAll().subscribe(
            resources => this.categorias = resources.sort((a, b) => b.id - a.id),
            error => alert('Erro ao carregar a lista')
        )
    }

    deleteResource(categoria) {
        const mustDelete = confirm('Deseja realmente excluir este item?');

        if (mustDelete) {
            this.categoriaService.delete(categoria.id)
                .subscribe(
                    value => {
                        this.categorias.splice(categoria.id);
                        this.categorias = this.categorias.filter(element => element != categoria)
                        toastr.success("Registro deletado com sucesso");
                    },
                    error => toastr.error(`Erro ao excluir registro! ${error}`)
                );
        }
    }
}
