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

  public tempList : Team[] = [];
  public teams : Team[] = [];
  public match !: Match;

  isTrue : boolean = true;

  constructor(private httpService : HttpService) { }

  ngOnInit(): void {

    this.getMatches();

  }

  public getTeams(){
    this.httpService.getTeams().subscribe(res =>{

      this.teams = res;
    })
  }

  public getMatches(){
    this.httpService.getAllMatches().subscribe(res=>{
      this.matches = res;
    })
  }



}
