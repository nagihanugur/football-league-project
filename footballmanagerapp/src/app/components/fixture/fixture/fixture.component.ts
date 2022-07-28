import { Component, OnInit } from '@angular/core';
import {Team} from "../../../team";
import {Match} from "../../../match";
import {HttpService} from "../../../services/http.service";
import {HttpErrorResponse} from "@angular/common/http";

@Component({
  selector: 'app-fixture',
  templateUrl: './fixture.component.html',
  styleUrls: ['./fixture.component.css']
})
export class FixtureComponent implements OnInit {

  public matches: Match[] = [];
  isTrue : boolean = true;

  constructor(private httpService : HttpService) { }

  ngOnInit(): void {


    this.createAllFixture();
  }

  public createAllFixture(){

      this.httpService.createFixture().subscribe(
        (response: Match []) => {
          this.matches = response;
        },
        (error: HttpErrorResponse) => {
          alert(error.message);
        });




  }












}
