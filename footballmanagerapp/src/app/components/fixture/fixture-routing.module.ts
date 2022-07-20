import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {FixtureComponent} from "./fixture/fixture.component";

const routes: Routes = [
  {
    path : '',
    component : FixtureComponent
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class FixtureRoutingModule { }
