import {Component, OnInit} from '@angular/core';

import {HttpErrorResponse} from "@angular/common/http";
import {HttpService} from "./services/http.service";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit{
  title = 'footballmanagerapp';



  constructor(private httpService : HttpService) {
  }

  ngOnInit() {

  }



}
