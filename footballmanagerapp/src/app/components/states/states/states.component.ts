import { Component, OnInit } from '@angular/core';
import {Team} from "../../../team";
import {HttpErrorResponse} from "@angular/common/http";
import {HttpService} from "../../../services/http.service";
import {League} from "../../../League";

@Component({
  selector: 'app-states',
  templateUrl: './states.component.html',
  styleUrls: ['./states.component.css']
})
export class StatesComponent implements OnInit {

  public teams : Team[]= [];
  public leagues : League[]=[];
  selectedLeague !: League;

  constructor(private httpService : HttpService) { }

  ngOnInit(): void {
    this.loadLeagues();

  }

  loadLeagues():void{
    this.httpService.getAllLeague().subscribe(res=> {
      this.leagues = res;
      console.log(this.leagues);
    });

  }

  onChangeObj({newLeague}: { newLeague: any }){
    this.selectedLeague = newLeague;
    console.log(this.selectedLeague);
    this.getTeamList();

  }
  getTeamList() {

    this.httpService.getTeamsByLeagueId(this.selectedLeague.leagueId).subscribe((response) => {
      this.teams = response;
      console.log(response);
    })

  }


  public getTeams(): void{
    this.httpService.getTeams().subscribe(
      (response : Team [])=>{
        this.teams = response;
      },
      (error : HttpErrorResponse)=>{
        alert(error.message);
      });
  }

}
