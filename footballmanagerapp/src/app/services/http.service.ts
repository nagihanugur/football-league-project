import { Injectable } from '@angular/core';
import {environment} from "../../environments/environment";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Team} from "../team";

@Injectable({
  providedIn: 'root'
})
export class HttpService {

  private apiServerUrl = environment.apiBaseUrl;

  constructor(private http: HttpClient) { }

  public getTeams() : Observable<Team[]>{
    return this.http.get<Team[]>(`${this.apiServerUrl}/teams`);
  }

  public getTeamById(teamId : number) : Observable<Team>{
    return this.http.get<Team>(`${this.apiServerUrl}/teams/${teamId}`);
  }

  public addTeam(team : Team) : Observable<Team>{
    return this.http.post<Team>(`${this.apiServerUrl}/teams/save`,team);
  }

  public deleteTeam(teamId : number) : Observable<void>{
    return this.http.delete<void>(`${this.apiServerUrl}/teams/delete/${teamId}`);
  }
}