import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup} from "@angular/forms";
import {HttpService} from "../../../services/http.service";
import {ActivatedRoute} from "@angular/router";

@Component({
  selector: 'app-update-team',
  templateUrl: './update-team.component.html',
  styleUrls: ['./update-team.component.css']
})
export class UpdateTeamComponent implements OnInit {

  updateForm!: FormGroup;
  message : Boolean =false;

  constructor(private httpService : HttpService, private fb : FormBuilder, private router : ActivatedRoute) { }


  ngOnInit(): void {

   this.httpService.getTeamById(this.router.snapshot.params['teamId']).subscribe(
     result=>{

       this.updateForm = this.fb.group({

         name : result['name'],
         emblem : result['emblem'],
         features : result['features'],
         power : result['power'],
         point : result['point']
       });
     }
   )
  }
  updateTeam(){

    this.httpService.updateTeam(this.updateForm.value, this.router.snapshot.params['teamId']).subscribe(result=>{
      console.log(result);
      this.message = true;
    });


  }

  removeMessage(){
    this.message = false;
  }

}
