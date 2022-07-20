import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { FixtureRoutingModule } from './fixture-routing.module';
import { FixtureComponent } from './fixture/fixture.component';


@NgModule({
  declarations: [
    FixtureComponent
  ],
  imports: [
    CommonModule,
    FixtureRoutingModule
  ]
})
export class FixtureModule { }
