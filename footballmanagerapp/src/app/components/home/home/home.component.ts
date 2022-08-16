import { Component, OnInit } from '@angular/core';
import {HttpService} from "../../../services/http.service";
import {Team} from "../../../team";
import {HttpErrorResponse} from "@angular/common/http";

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  constructor(private httpService : HttpService) { }

  public filteredTeams : Team[] = [];


  ngOnInit(): void {

    this.getFilteredTeams();

  }

  public getFilteredTeams():void{
    this.httpService.getTeams().subscribe(
      (response : Team [])=>{

        this.filteredTeams = response.slice(2,5);

      },
      (error : HttpErrorResponse)=>{
        alert(error.message);
      }

    );
  }



  }


