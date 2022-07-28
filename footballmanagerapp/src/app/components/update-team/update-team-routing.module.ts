import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {UpdateTeamComponent} from "./update-team/update-team.component";

const routes: Routes = [
  {
    path : '',
    component : UpdateTeamComponent
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class UpdateTeamRoutingModule { }
