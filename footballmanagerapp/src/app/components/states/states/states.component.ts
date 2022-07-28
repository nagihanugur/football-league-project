import { Component, OnInit } from '@angular/core';
import {Team} from "../../../team";
import {HttpErrorResponse} from "@angular/common/http";
import {HttpService} from "../../../services/http.service";

@Component({
  selector: 'app-states',
  templateUrl: './states.component.html',
  styleUrls: ['./states.component.css']
})
export class StatesComponent implements OnInit {

  public teams : Team[]= [];

  constructor(private httpService : HttpService) { }

  ngOnInit(): void {
    this.getTeams();
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
