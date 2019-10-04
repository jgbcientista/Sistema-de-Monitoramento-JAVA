import { OnInit, AfterContentChecked, Injector } from "@angular/core";

import { ActivatedRoute, Router } from '@angular/router';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

import toastr from "toastr";
import { BaseResourceModel } from "../../models/base-resource.model";

export class BaseResourceFormComponent<T extends BaseResourceModel> implements OnInit {

    serverErrorMessages: string[] = null;

    resource: { new(): T };
    public resourceForm: FormGroup;

    protected route: ActivatedRoute;
    protected router: Router;
    protected fb: FormBuilder;

    submittingForm: boolean = false;

    currentAction: string;
    pageTitle: string;

    constructor(
        protected injector: Injector
    ) {
        this.route = this.injector.get(ActivatedRoute);
        this.router = this.injector.get(Router);
        this.fb = this.injector.get(FormBuilder);
    }

    ngOnInit() { }

    submitForm() {
        this.submittingForm = true;
        if (this.currentAction == "new")
            this.createResource();
        else // currentAction == "edit"
            this.updateResource();
    }

    protected setCurrentAction() {
        if (this.route.snapshot.url[0].path == "new")
            this.currentAction = "new"
        else
            this.currentAction = "edit"
    }

    protected createResource() {
        const resource: T = Object.assign(new this.resource(), this.resourceForm.value);

        // this.resourceService.create(resource)
        //     .subscribe(
        //         resource => this.actionsForSuccess(resource),
        //         error => this.actionsForError(error)
        //     )
    }

    protected updateResource() {

    }

    protected actionsForSuccess(resource: T) {
        toastr.success("Solicitação processada com sucesso!");

        // const baseComponentPath: string = this.route.snapshot.parent.url[0].path;

        // // redirect/reload component page
        // this.router.navigateByUrl(baseComponentPath, { skipLocationChange: true }).then(
        //     () => this.router.navigate([baseComponentPath, resource.id, "edit"])
        // )
    }

    protected actionsForError(error) {
        toastr.error("Ocorreu um erro ao processar a sua solicitação!");

        this.submittingForm = false;

        if (error.status === 422)
            this.serverErrorMessages = JSON.parse(error._body).errors;
        else
            this.serverErrorMessages = ["Falha na comunicação com o servidor. Por favor, tente mais tarde."]
    }

    protected setPageTitle() {
        // if (this.currentAction == 'new')
        //   this.pageTitle = this.creationPageTitle();
        // else {
        //   this.pageTitle = this.editionPageTitle();
        // }
    }
}