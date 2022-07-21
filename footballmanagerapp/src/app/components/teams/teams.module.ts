import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { TeamsRoutingModule } from './teams-routing.module';
import { SaveTeamComponent } from '../save-team/save-team/save-team.component';
import {ReactiveFormsModule} from "@angular/forms";


@NgModule({
  declarations: [
    SaveTeamComponent
  ],
    imports: [
        CommonModule,
        TeamsRoutingModule,
        ReactiveFormsModule
    ]
})
export class TeamsModule { }
