import {Component, OnInit} from '@angular/core';
import {Match} from "../../../match";
import {HttpService} from "../../../services/http.service";
import {HttpErrorResponse} from "@angular/common/http";
import {Team} from "../../../team";


@Component({
  selector: 'app-play',
  templateUrl: './play.component.html',
  styleUrls: ['./play.component.css']
})
export class PlayComponent implements OnInit {

  public matches: Match [] = [];
  match !: Match;
  team !: Team;
  team2 !: Team;
  isShow : boolean= false;
  public updatedMatches : Match[] = [];

  constructor(private httpService: HttpService) {


  }

  ngOnInit(): void {
    this.getAllMatches();

  }

  getAllMatches(){

    this.httpService.getAllMatches().subscribe(res=>{
      this.matches = res;
    })
  }




  playGame(id: number) {

    this.httpService.getMatch(id).subscribe(result => {

      this.match = result;
      console.log(this.match);

      if (this.match.teamFirst.power <= 20 && this.match.teamFirst.power > 0) {

        this.match.goalFt = Math.floor(Math.random() * 2);

      }
      if (this.match.teamFirst.power > 20 && this.match.teamFirst.power <= 40) {

        this.match.goalFt = Math.floor(Math.random() * 3);

      }

      if (this.match.teamFirst.power > 40 && this.match.teamFirst.power <= 50) {

        this.match.goalFt = Math.floor(Math.random() * 4);

      }

      if (this.match.teamFirst.power > 50 && this.match.teamFirst.power <= 60) {

        this.match.goalFt = Math.floor(Math.random() * 5);

      }
      if (this.match.teamFirst.power > 60 && this.match.teamFirst.power <= 70) {

        this.match.goalFt = Math.floor(Math.random() * 6);

      }
      if (this.match.teamFirst.power > 70 && this.match.teamFirst.power <= 100) {

        this.match.goalFt = Math.floor(Math.random() * 8);


      }
      // teamSecond

      if (this.match.teamSecond.power <= 20 && this.match.teamSecond.power > 0) {

        this.match.goalSt = Math.floor(Math.random() * 2);
      }
      if (this.match.teamSecond.power > 20 && this.match.teamSecond.power <= 40) {

        this.match.goalSt = Math.floor(Math.random() * 3);

      }
      if (this.match.teamSecond.power > 40 && this.match.teamSecond.power <= 50) {

        this.match.goalSt = Math.floor(Math.random() * 4);

      }
      if (this.match.teamSecond.power > 50 && this.match.teamSecond.power <= 60) {

        this.match.goalSt = Math.floor(Math.random() * 5); //0 -4 arasında gol

      }
      if (this.match.teamSecond.power > 60 && this.match.teamSecond.power <= 70) {

        this.match.goalSt = Math.floor(Math.random() * 6); // 0-5

      }
      if (this.match.teamSecond.power > 70 && this.match.teamSecond.power <= 100) {

        this.match.goalSt = Math.floor(Math.random() * 8);
      }

      // match

      if (this.match.goalFt > this.match.goalSt) {

        this.match.teamFirst.power += 10;
        this.match.teamFirst.point += 3;
        this.match.teamSecond.power -= 10;

        this.httpService.updateMatch(this.match).subscribe(res =>{
          this.updatedMatches.push(res);
          this.isShow = true;
          console.log(this.matches);
        });



      }
      if (this.match.goalFt < this.match.goalSt) {

        this.match.teamFirst.power -= 10;
        this.match.teamSecond.power += 10;
        this.match.teamSecond.point += 3;

        this.httpService.updateMatch(this.match).subscribe(res =>{
          this.updatedMatches.push(res);
          this.isShow = true;
          console.log(this.matches);
        });


      }
      if (this.match.goalFt == this.match.goalSt) {

        this.match.teamFirst.point += 1;
        this.match.teamSecond.point += 1;

        this.httpService.updateMatch(this.match).subscribe(res =>{
          this.updatedMatches.push(res);
          this.isShow = true;
          console.log(this.matches);

        });



      }
    });

    setTimeout(function () {

      window.location.reload();

    }, 1000);


  }

  public close(){
    this.isShow = false;


  }



}
