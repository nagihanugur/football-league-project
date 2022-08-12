import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import {HttpClientModule} from "@angular/common/http";
import { TeamsComponent } from './components/teams/teams/teams.component';
import {HttpService} from "./services/http.service";
import { HomeComponent } from './components/home/home/home.component';
import { HeaderComponent } from './components/header/header.component';
import {RouterModule} from "@angular/router";
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {OrderModule} from "ngx-order-pipe";
import { LeaguesComponent } from './components/leagues/leagues/leagues.component';


@NgModule({
  declarations: [
    AppComponent,
    TeamsComponent,
    HomeComponent,
    HeaderComponent,
    LeaguesComponent,
  ],
    imports: [
        BrowserModule,
        AppRoutingModule,
        HttpClientModule,
        RouterModule,
        ReactiveFormsModule,
        OrderModule,
        FormsModule
    ],
  providers: [
    HttpService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
