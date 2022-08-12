import { Component, OnInit } from '@angular/core';
import {League} from "../../../League";
import {HttpService} from "../../../services/http.service";
import {Team} from "../../../team";
import {Match} from "../../../match";

@Component({
  selector: 'app-leagues',
  templateUrl: './leagues.component.html',
  styleUrls: ['./leagues.component.css']
})
export class LeaguesComponent implements OnInit {

  constructor(private httpService: HttpService) { }
  leagues: League[]=[];
  teams : Team[]=[];
  selectedLeague !: League;
  matches : Match[]=[];

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

  deleteLeague(){
    this.httpService.deleteLeague(this.selectedLeague.leagueId).subscribe();
    setTimeout(function () {

      window.location.reload();

    }, 1000);
  }

  getTeamList() {

    this.httpService.getTeamsByLeagueId(this.selectedLeague.leagueId).subscribe((response) => {
      this.teams = response;
      console.log(response);
    })

  }

  getMatches(){
    this.httpService.getMatchesByLeagueId(this.selectedLeague.leagueId).subscribe(response=>{
      this.matches = response;
      console.log(response);
    })
  }

  createFixture(){

    this.httpService.createFixture(this.selectedLeague.leagueId).subscribe(response=>{

      console.log("create -"+response);
    })
    //this.matches = [];

  }

  deleteFixture(){
    this.httpService.deleteMatchByLeagueId(this.selectedLeague.leagueId).subscribe(()=>{
    })


  }
}
