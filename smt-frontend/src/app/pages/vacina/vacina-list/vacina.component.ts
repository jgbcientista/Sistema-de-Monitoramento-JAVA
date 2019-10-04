import { Component, OnInit } from '@angular/core';
import toastr from "toastr";
import { VacinaService } from '../vacina.service';
import { Vacina } from '../vacina.model';

@Component({
    selector: 'bill-vacina',
    templateUrl: './vacina.component.html',
    styleUrls: ['./vacina.component.css']
})
export class VacinaComponent implements OnInit {

    vacinas: Vacina[] = [];

    constructor(private vacinaService: VacinaService) { }

    ngOnInit() {
       this.getAll();
    }

    getAll() {
        this.vacinaService.getAll().subscribe(
            resources => this.vacinas = resources.sort((a, b) => b.id - a.id),
            error => alert('Erro ao carregar a lista')
        )
    }

    deleteResource(vacina) {
        const mustDelete = confirm('Deseja realmente excluir este item?');
        if (mustDelete) {
            this.vacinaService.delete(vacina.id)
                .subscribe(
                    value => {
                        this.vacinas.splice(vacina.id);
                        this.vacinas = this.vacinas.filter(element => element != vacina)
                        toastr.success("Registro deletado com sucesso");
                    },
                    error => toastr.error(`Erro ao excluir registro! ${error}`)
                );
        }
    }
}
