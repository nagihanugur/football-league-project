import { Component, OnInit } from '@angular/core';
import {Team} from "../../../team";
import {Match} from "../../../match";
import {HttpService} from "../../../services/http.service";
import {HttpErrorResponse} from "@angular/common/http";
import {ActivatedRoute} from "@angular/router";



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
 // selectedLeague = this.router.snapshot.params['leagueId'];

  constructor(private httpService : HttpService,private router : ActivatedRoute) { }

  selectedLeague = this.router.snapshot.params['leagueId'];
  ngOnInit(): void {

    this.getMatches();

  }

  public getTeams(){
    this.httpService.getTeams().subscribe(res =>{

      this.teams = res;
    })
  }

  getMatches(){
    this.httpService.getMatchesByLeagueId(this.router.snapshot.params['leagueId']).subscribe(response=>{
      this.matches = response;
      console.log(this.selectedLeague);
    })
  }



}
