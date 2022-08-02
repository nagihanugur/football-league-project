import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { FixtureRoutingModule } from './fixture-routing.module';
import { FixtureComponent } from './fixture/fixture.component';
import {OrderModule} from "ngx-order-pipe";


@NgModule({
  declarations: [
    FixtureComponent
  ],
    imports: [
        CommonModule,
        FixtureRoutingModule,
        OrderModule
    ]
})
export class FixtureModule { }
