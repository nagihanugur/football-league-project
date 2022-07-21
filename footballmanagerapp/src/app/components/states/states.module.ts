import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { StatesRoutingModule } from './states-routing.module';
import { StatesComponent } from './states/states.component';


@NgModule({
  declarations: [
    StatesComponent
  ],
  imports: [
    CommonModule,
    StatesRoutingModule
  ]
})
export class StatesModule { }
