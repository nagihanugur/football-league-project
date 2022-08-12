import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {LeaguesComponent} from "./leagues/leagues.component";

const routes: Routes = [
  {
    path : '',
    component : LeaguesComponent
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class LeaguesRoutingModule { }
