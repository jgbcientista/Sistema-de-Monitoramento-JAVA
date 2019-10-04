import { BaseResourceModel } from "src/app/shared/models/base-resource.model";

export class Vacina extends BaseResourceModel {
    constructor(
        id?: number,
        nome?: string,
        responsavel?: string,
        lote?: number,
        temperaturaRegistrada?: string,
        dataAplicacao?: Date
        
        
        
        ) {
        super();
    }

    static fromJson(jsonData: any): Vacina {
        return Object.assign(new Vacina(), jsonData);
    }
}