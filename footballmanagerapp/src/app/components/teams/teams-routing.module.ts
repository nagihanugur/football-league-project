import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {TeamsComponent} from "./teams/teams.component";
import {SaveTeamComponent} from "../save-team/save-team/save-team.component";

const routes: Routes = [

  {
    path : '',
    component : TeamsComponent,

  },
  {
    path : 'saveTeam',
    component : SaveTeamComponent

  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class TeamsRoutingModule { }
