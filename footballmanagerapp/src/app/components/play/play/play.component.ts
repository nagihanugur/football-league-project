import { Component, OnInit } from '@angular/core';
import {Match} from "../../../match";
import {HttpService} from "../../../services/http.service";
import {HttpErrorResponse} from "@angular/common/http";


@Component({
  selector: 'app-play',
  templateUrl: './play.component.html',
  styleUrls: ['./play.component.css']
})
export class PlayComponent implements OnInit {

  public matches : Match [] = [];
  match : Match | null;

  constructor(private httpService : HttpService) {
    this.match=null;
  }

  ngOnInit(): void {
    this.getCreatingMatches();
  }

  getCreatingMatches(){

    this.httpService.createFixture().subscribe(
      (response: Match []) => {
        this.matches = response;
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    )
  }

  playGame(id : number){

    this.httpService.getMatch(id).subscribe(result =>{

      this.match = result;
      console.log(this.match)

    });


    if(this.match?.teamFirst.power <= 20 && this.match?.teamFirst.power> 0){

      if(this.match != undefined){
        this.match.goalFt = Math.floor(Math.random() * 2);
      }

      }
      if(this.match?.teamFirst.power > 20 && this.match?.teamFirst.power <= 40 ){

        if(this.match != undefined){
          this.match.goalFt = Math.floor(Math.random() * 3);
        }
        // this.match.goalFt = Math.floor(Math.random() * 3);
      }
      if(this.match?.teamFirst.power > 40 && this.match?.teamFirst.power <= 50 ){
        if(this.match != undefined){
          this.match.goalFt = Math.floor(Math.random() * 4);
        }
        // this.match.goalFt = Math.floor(Math.random() * 4);
      }
      if(this.match?.teamFirst.power > 50 && this.match?.teamFirst.power<= 60 ){

        if(this.match != undefined){
          this.match.goalFt = Math.floor(Math.random() * 5);
        }
        //  this.match?.goalFt = Math.floor(Math.random() * 5); //0 -4 arasında gol
      }
      if(this.match?.teamFirst.power> 60 && this.match?.teamFirst.power <= 70 ){
        if(this.match != undefined){
          this.match.goalFt = Math.floor(Math.random() * 6);
        }
        //  this.match?.goalFt = Math.floor(Math.random() * 6); // 0-5
      }
      if(this.match?.teamFirst.power > 70 && this.match?.teamFirst.power <= 100 ){
        if(this.match != undefined){
          this.match.goalFt = Math.floor(Math.random() * 8);
        }

      }
      // teamSecond

      if(this.match?.teamSecond.power <= 20 && this.match?.teamSecond.power > 0){

        if(this.match != undefined){
          this.match.goalSt = Math.floor(Math.random() * 2);
        }


      }
      if(this.match?.teamSecond.power > 20 && this.match?.teamSecond.power<= 40 ){
        if(this.match != undefined){
          this.match.goalSt = Math.floor(Math.random() * 3);
        }
      }
      if(this.match?.teamSecond.power > 40 && this.match?.teamSecond.power<= 50 ){
        if(this.match != undefined){
          this.match.goalSt = Math.floor(Math.random() * 4);
        }
      }
      if(this.match?.teamSecond.power> 50 && this.match?.teamSecond.power<= 60 ){
        if(this.match != null){
          this.match.goalSt = Math.floor(Math.random() * 5); //0 -4 arasında gol
        }
      }
      if(this.match?.teamSecond.power > 60 && this.match?.teamSecond.power <= 70 ){
        if(this.match != null){
          this.match.goalSt = Math.floor(Math.random() * 6); // 0-5
        }
      }
      if(this.match?.teamSecond.power> 70 && this.match?.teamSecond.power <= 100 ){
        if(this.match != null){
          this.match.goalSt = Math.floor(Math.random() * 8)
        }
      }

      // match

     if(this.match != null){
       if(this.match.goalFt > this.match.goalSt){

           this.match.teamFirst.power += 10;
           this.match.teamSecond.power -= 10;


         console.log(this.match.matchId+"Team first won..")
       }
       if(this.match.goalFt < this.match.goalSt){
         this.match.teamFirst.power -= 10;
         this.match.teamSecond.power += 10;
         console.log(this.match.matchId+"Team second won..")
       }
       if(this.match.goalFt = this.match.goalSt){

         console.log(this.match.matchId+"berabere")
       }

     }
    }




}