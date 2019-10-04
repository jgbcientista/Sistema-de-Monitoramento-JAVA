import { Component, OnInit, Injector, ViewChild, ElementRef } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { CategoriaService } from '../categoria.service';
import { BaseResourceFormComponent } from 'src/app/shared/components/base-resource-form/BaseResourceFormComponent';
import { Categoria } from '../categoria.model';
import { switchMap } from 'rxjs/operators';
import toastr from "toastr";
import { Router } from '@angular/router';

@Component({
    selector: 'bill-categoria-form',
    templateUrl: './categoria-form.component.html'
})
export class CategoriaFormComponent extends BaseResourceFormComponent<Categoria> implements OnInit {

    categoria: Categoria;
    @ViewChild("nome") nomeField: ElementRef;

    constructor(
        private categoriaService: CategoriaService,
        protected injector: Injector,
        router: Router) {
        super(injector);
    }

    ngOnInit() {
        this.setCurrentAction();
        this.buildCategoriaForm();
        this.loadCategoria();
        this.nomeField.nativeElement.focus()
    }

    buildCategoriaForm() {
        this.resourceForm = this.fb.group({
            id: [null],
            nome: ['', Validators.required]
        })
    }

    loadCategoria() {
        if (this.currentAction == "edit") {

            this.route.paramMap.pipe(
                switchMap(params => this.categoriaService.getById(+params.get("id")))
            ).subscribe(
                (categoria) => {
                    this.categoria = categoria;
                    this.resourceForm.patchValue(categoria) // binds loaded resource data to resourceForm
                },
                (error) => toastr.error('Ocorreu um erro no servidor, tente mais tarde.')
            )
        }
    }

    protected createResource() {
        const resource: Categoria = Object.assign(new Categoria(), this.resourceForm.value);
        this.categoriaService.create(resource)
            .subscribe(
                // value => toastr.success("Registro inserido com sucesso"),
                // error => toastr.error(`Erro ao inserir registro! ${error}`)
                resource => {
                    this.actionsForSuccess(resource);
                    this.nomeField.nativeElement.focus();
                    console.log(this.nomeField.nativeElement)
                    this.nomeField.nativeElement.value = '';
                },
                error => this.actionsForError(error)
            );
    }

    protected updateResource() {
        // const resource: Categoria = this.jsonDataToResourceFn(this.categoriaForm.value);

        const resource: Categoria = Object.assign(new Categoria(), this.resourceForm.value);

        this.categoriaService.update(resource).subscribe(
            value => {
                toastr.success("Registro inserido com sucesso");
                this.router.navigate(['/app/pages/categorias', '']);
                
            },
            error => toastr.error(`Erro ao inserir registro! ${error}`)
        );
    }

    
}
