import { Injectable } from '@angular/core';

import { Observable, throwError } from 'rxjs';
import { map, catchError, flatMap, tap } from 'rxjs/operators';
import { Categoria } from './categoria.model';
import { HttpClient, HttpErrorResponse, HttpHeaders } from '@angular/common/http';

import { environment } from '../../../environments/environment';
@Injectable({
    providedIn: 'root'
})
export class CategoriaService {

    constructor(private http: HttpClient) { }

    public getAll() {
        // return this.http.get<Categoria[]>(`${environment.API_PATH}/categorias`);

        return this.http.get(`${environment.API_PATH}/categorias`).pipe(
            map(this.jsonDataToResources),
            catchError(this.handleError)
        );
    }

    public getById(id: number) {
        const url = `${environment.API_PATH}/categorias/${id}`;
        // return this.http.get<Categoria>(url);

        return this.http.get(url).pipe(
            map(this.jsonDataToResource.bind(this)),
            catchError(this.handleError)
        );
    }

    create(categoria: Categoria): Observable<Categoria> {
        const url = `${environment.API_PATH}/categorias`;

        return this.http.post<Categoria>(url, categoria);
    }

    update(categoria: Categoria): Observable<Categoria> {
        console.log("Chegou no Alterar");
        const url = `${environment.API_PATH}/categorias/${categoria.id}`;
        return this.http.put<Categoria>(url, categoria);
    }

    delete(id: number): Observable<Categoria> {
        const url = `${environment.API_PATH}/categorias/${id}`;
        console.log("Chegou no Deletar");
 
        return this.http.delete(url).pipe(
            catchError(err => this.handleError(err))
        );
    }

    // protected jsonDataToResources(jsonData: any[]): Categoria[] {
    //   const resources: Categoria[] = [];
    //   jsonData.forEach(
    //     element => resources.push( this.jsonDataToResourceFn(element) )
    //   );
    //   return resources;
    // }

    // protected jsonDataToResource(jsonData: any): Categoria {
    //   return this.jsonDataToResourceFn(jsonData);
    // }

    // protected handleError(error: any): Observable<any> {
    //   console.log('ERRO NA REQUISIÇÃO => ', error);
    //   return throwError(error);
    // }

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

    protected jsonDataToResources(jsonData: any[]): Categoria[] {
        const resources: Categoria[] = [];

        jsonData.forEach(
            element => resources.push(Categoria.fromJson(element))
        );
        console.log(resources);
        return resources;
    }

    protected jsonDataToResource(jsonData: any): Categoria {
        return Categoria.fromJson(jsonData);
    }

}
