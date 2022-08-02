import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { PlayRoutingModule } from './play-routing.module';
import { PlayComponent } from './play/play.component';
import {OrderModule} from "ngx-order-pipe";


@NgModule({
  declarations: [
    PlayComponent
  ],
    imports: [
        CommonModule,
        PlayRoutingModule,
        OrderModule
    ]
})
export class PlayModule { }
