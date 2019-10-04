import { Injectable } from '@angular/core';

import { Observable, throwError } from 'rxjs';
import { map, catchError, flatMap, tap } from 'rxjs/operators';
 import { HttpClient, HttpErrorResponse, HttpHeaders } from '@angular/common/http';

import { environment } from '../../../environments/environment';
import { Vacina } from './vacina.model';
@Injectable({
    providedIn: 'root'
})
export class VacinaService {

    constructor(private http: HttpClient) { }

    public getAll() {
        return this.http.get(`${environment.API_PATH}/vacinas`).pipe(
            map(this.jsonDataToResources),
            catchError(this.handleError)
        );
    }

    public getById(id: number) {
        const url = `${environment.API_PATH}/vacinas/${id}`;
           return this.http.get(url).pipe(
            map(this.jsonDataToResource.bind(this)),
            catchError(this.handleError)
        );
    }

    create(vacina: Vacina): Observable<Vacina> {
        const url = `${environment.API_PATH}/vacinas`;

        return this.http.post<Vacina>(url, vacina);
    }

    update(vacina: Vacina): Observable<Vacina> {
        const url = `${environment.API_PATH}/vacinas/${vacina.id}`;
        return this.http.put<Vacina>(url, vacina);
    }

    delete(id: number): Observable<Vacina> {
        const url = `${environment.API_PATH}/vacinas/${id}`;
        console.log("Chegou no Deletar");
 
        return this.http.delete(url).pipe(
            catchError(err => this.handleError(err))
        );
    }

    private handleError(error: HttpErrorResponse) {
        if (error.error instanceof ErrorEvent) {
            // A client-side or network error occurred. Handle it accordingly.
            console.error('An error occurred:', error.error.message);
        } else {
            // The backend returned an unsuccessful response code.
            // The response body may contain clues as to what went wrong,
            console.error(
                `Backend returned code ${error.status}, ` +
                `body was: ${error.error}`);
        }
        // return an observable with a user-facing error message
        return throwError(
            'Something bad happened; please try again later.');
    };

    protected jsonDataToResources(jsonData: any[]): Vacina[] {
        const resources: Vacina[] = [];

        jsonData.forEach(
            element => resources.push(Vacina.fromJson(element))
        );
        console.log(resources);
        return resources;
    }

    protected jsonDataToResource(jsonData: any): Vacina {
        return Vacina.fromJson(jsonData);
    }

}
