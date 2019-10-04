import { BrowserModule } from '@angular/platform-browser';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';

import { NgModule, LOCALE_ID } from '@angular/core';

import { CommonModule } from '@angular/common';


import { RouterModule } from '@angular/router';
import { AppRoutingModule } from './app-routing.modules';

import { AppComponent } from './app.component';
import { BillNavbarComponent } from './bill-navbar/bill-navbar.component';
import { HomeComponent } from './pages/home/home.component';

import { registerLocaleData } from '@angular/common';
import ptBr from '@angular/common/locales/pt';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { LoginComponent } from './pages/login/login.component';

registerLocaleData(ptBr)

@NgModule({
    declarations: [
        AppComponent,
        BillNavbarComponent,
        HomeComponent,
        LoginComponent
    ],
    imports: [
        BrowserModule,
        BrowserAnimationsModule,
        RouterModule,
        AppRoutingModule,
        FormsModule,
        HttpClientModule
    ],
    exports: [
        CommonModule,
        RouterModule
    ],
    providers: [{ provide: LOCALE_ID, useValue: 'pt' }],
    bootstrap: [AppComponent]
})
export class AppModule { }