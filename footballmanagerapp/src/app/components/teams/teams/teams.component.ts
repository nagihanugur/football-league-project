import { Component, OnInit } from '@angular/core';
import {Team} from "../../../team";
import {HttpService} from "../../../services/http.service";
import {HttpErrorResponse} from "@angular/common/http";
import {Match} from "../../../match";
import {FormBuilder, FormGroup} from "@angular/forms";



@Component({
  selector: 'app-teams',
  templateUrl: './teams.component.html',
  styleUrls: ['./teams.component.css']
})
export class TeamsComponent implements OnInit {

  public teams: Team[] = [];
  public matches : Match[]=[];
  message: Boolean = false;

  leagueForm ! : FormGroup;


  constructor(private httpService: HttpService, private fb : FormBuilder) {
  }

  ngOnInit(): void {

    this.leagueForm = this.fb.group({
      name : '',

    })

    this.getTeams();

  }


  public getTeams(): void {
    this.httpService.getTeams().subscribe(
      (response: Team []) => {
        this.teams = response;
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      });

  }

  public deleteTeam(id: number): void {

    this.httpService.deleteTeam(id).subscribe(
      () => {
        console.log("Team id : " + id + " is deleted successfully");
        this.getTeams();
      }
    );
    this.message = true

  }

  public removeMessage() {
    this.message = false;
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

  public deleteAll(){
    this.httpService.deleteAllTeam().subscribe(()=>{
      this.getTeams();
      }
    );
  }


}
