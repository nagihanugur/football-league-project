import { Component, OnInit } from '@angular/core';
import {Team} from "../../../team";
import {HttpService} from "../../../services/http.service";
import {HttpErrorResponse} from "@angular/common/http";



@Component({
  selector: 'app-teams',
  templateUrl: './teams.component.html',
  styleUrls: ['./teams.component.css']
})
export class TeamsComponent implements OnInit {

  public teams: Team[] = [];
  message: Boolean = false;


  constructor(private httpService: HttpService) {
  }

  ngOnInit(): void {

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
        console.log("Team id : " + id + " is deleted successfully")
      }
    );
    this.message = true

  }

  public removeMessage() {
    this.message = false;
  }


}
