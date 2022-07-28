import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {PlayComponent} from "./play/play.component";

const routes: Routes = [
  {
    path: '',
    component: PlayComponent,
    pathMatch : "full"
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class PlayRoutingModule { }
