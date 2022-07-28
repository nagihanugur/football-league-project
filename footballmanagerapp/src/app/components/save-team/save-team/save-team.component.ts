import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup} from "@angular/forms";
import {HttpService} from "../../../services/http.service";
import {Team} from "../../../team";



@Component({
  selector: 'app-save-team',
  templateUrl: './save-team.component.html',
  styleUrls: ['./save-team.component.css']
})
export class SaveTeamComponent implements OnInit {

  teamForm ! : FormGroup;
  team : Team [] = [];
  message : Boolean=false;



  constructor(private http : HttpService, private fb : FormBuilder) { }

  ngOnInit(): void {
    this.teamForm = this.fb.group({
      name : '',
      emblem : '',
      features : '',
      power : 50,
      point : 0,
      gameState : this.fb.group({
        stateId : null,
        won : 0,
        lose : 0,
        draw : 0,
        played : 0
      })
    });


  }

  createTeam(){


     this.http.addTeam(this.teamForm.value).subscribe((result) =>
     console.log(result));
    this.message = true;
  }

  removeMessage(){
    this.message = false;
  }





}
