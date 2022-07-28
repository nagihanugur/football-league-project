import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { UpdateTeamRoutingModule } from './update-team-routing.module';
import { UpdateTeamComponent } from './update-team/update-team.component';
import {ReactiveFormsModule} from "@angular/forms";


@NgModule({
  declarations: [
    UpdateTeamComponent
  ],
    imports: [
        CommonModule,
        UpdateTeamRoutingModule,
        ReactiveFormsModule
    ]
})
export class UpdateTeamModule { }
