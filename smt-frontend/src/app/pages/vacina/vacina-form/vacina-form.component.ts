import { Component, OnInit, Injector, ViewChild, ElementRef } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { VacinaService } from '../vacina.service';
import { BaseResourceFormComponent } from 'src/app/shared/components/base-resource-form/BaseResourceFormComponent';
import { Vacina } from '../vacina.model';
import { switchMap } from 'rxjs/operators';
import toastr from "toastr";
import { Router } from '@angular/router';

@Component({
    selector: 'bill-vacina-form',
    templateUrl: './vacina-form.component.html'
})
export class VacinaFormComponent extends BaseResourceFormComponent<Vacina> implements OnInit {

    vacina: Vacina;
    @ViewChild("nome") nomeField: ElementRef;
    lote: number = 0;
    responsavel: string;
    temperaturaRegistrada: number;
    dataAplicacao: Date;
  

    constructor(
        private vacinaService: VacinaService,
        protected injector: Injector,
        router: Router) {
        super(injector);
    }

    ngOnInit() {
        this.setCurrentAction();
        this.buildForm();
        this.load();
        this.nomeField.nativeElement.focus()
    }

    buildForm() {
        this.resourceForm = this.fb.group({
            id: [null],
            nome: ['', Validators.required],
            lote: ['', Validators.required],
            temperaturaRegistrada: ['', Validators.required],
            dataAplicacao: ['', Validators.required],
            responsavel: ['', Validators.required]
        })
    }

    load() {
        if (this.currentAction == "edit") {

            this.route.paramMap.pipe(
                switchMap(params => this.vacinaService.getById(+params.get("id")))
            ).subscribe(
                (vacina) => {
                    this.vacina = vacina;
                    this.resourceForm.patchValue(vacina) // binds loaded resource data to resourceForm
                },
                (error) => toastr.error('Ocorreu um erro no servidor, tente mais tarde.')
            )
        }
    }

    protected createResource() {
        const resource: Vacina = Object.assign(new Vacina(), this.resourceForm.value);
        this.vacinaService.create(resource)
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
        console.log("JOAO");
        console.log(this.resourceForm.value);
        this.vacina = this.resourceForm.value;
        this.vacinaService.update(this.vacina).subscribe(
            value => {
                toastr.success("Registro inserido com sucesso");
                //this.router.navigate(['/app/pages/vacinas', '']);
                
            },
            error => toastr.error(`Erro ao inserir registro! ${error}`)
        );
    }

    
}
