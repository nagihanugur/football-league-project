import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {SaveTeamComponent} from "./save-team/save-team.component";

const routes: Routes = [
  {
    path : '',
    component : SaveTeamComponent
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class SaveTeamRoutingModule { }
