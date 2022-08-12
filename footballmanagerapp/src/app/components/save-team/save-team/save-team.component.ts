import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup, FormArray} from "@angular/forms";
import {HttpService} from "../../../services/http.service";
import {Team} from "../../../team";
import {League} from "../../../League";
import {Match} from "../../../match";
import {HttpErrorResponse} from "@angular/common/http";


@Component({
  selector: 'app-save-team',
  templateUrl: './save-team.component.html',
  styleUrls: ['./save-team.component.css']
})
export class SaveTeamComponent implements OnInit {

   team = new Team();
   teams : Team []=[];
   teamList : Team []=[];
   league = new League();
  public matches : Match[]=[];

  teamLeagueList : Team[] = [];

  leagueStatic !: League;
  message : Boolean=false;
  savedLeague !: League;


  constructor(private http : HttpService, private fb : FormBuilder) { }

  ngOnInit(): void {

  }


  createLeague(){

    this.http.saveLeague(this.league).subscribe((result)=>{
      console.log(result);
      this.savedLeague = result;
    });

  }

  createTeam(){

    this.team.leagueDto = this.savedLeague;
    console.log(this.team);
    this.http.addTeam(this.team).subscribe((result) =>{

      console.log(result);
    });
    this.message = true;
    this.teams.push(this.team);
    this.savedLeague.teams?.push(this.team);
    this.team = {
      name : '',
      emblem : '',
      features : '',
      power : 50,
      point : 0,
      won : 0,
      lose : 0,
      played : 0,
      draw : 0,
    }

    console.log(this.savedLeague);

  }

  public getTeams(): void {
    this.http.getTeams().subscribe(
      (response: Team []) => {
        this.teamList = response;
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      });

  }
 /* public createAllFixture(){
    this.getTeamList();

    this.http.createFixture().subscribe(
      (response: Match []) => {
        this.matches = response;
        console.log(this.matches)
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      });

  } */

  removeMessage(){
    this.message = false;
  }

  getTeamList(){


    this.http.getTeamsByLeagueId(this.savedLeague.leagueId).subscribe((response)=>{
      this.teamLeagueList = response;
      console.log(response);
    })
  }

}
