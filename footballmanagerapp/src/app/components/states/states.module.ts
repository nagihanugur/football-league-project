import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { StatesRoutingModule } from './states-routing.module';
import { StatesComponent } from './states/states.component';
import {OrderModule} from "ngx-order-pipe";


@NgModule({
  declarations: [
    StatesComponent
  ],
    imports: [
        CommonModule,
        StatesRoutingModule,
        OrderModule
    ]
})
export class StatesModule { }
