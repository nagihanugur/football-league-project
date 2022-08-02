import { Injectable } from '@angular/core';
import {environment} from "../../environments/environment";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Team} from "../team";
import {Goal} from "../goal";
import {Match} from "../match";

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
  public deleteAllTeam():Observable<void>{
    return this.http.delete<void>(`${this.apiServerUrl}/teams/delete`)
  }

  public updateTeam(team : Team, teamId : number) : Observable<Team>{
    return this.http.put<Team>(`${this.apiServerUrl}/teams/update/${teamId}`,team);
  }

  public getAllMatches() : Observable<Match[]>{
    return this.http.get<Match[]>(`${this.apiServerUrl}/matches`);
  }
  public createFixture() : Observable<Match[]>{
    return this.http.get<Match[]>(`${this.apiServerUrl}/matches/create`)
  }

  public updateMatch(match : Match) :Observable<Match>{
    return this.http.put<Match>(`${this.apiServerUrl}/matches/update`,match)
  }

  public saveMatch(matchList : Match[]):Observable<Match[]>{
    return this.http.post<Match[]>(`${this.apiServerUrl}/matches/save`,matchList)
  }


  public getMatch(matchId : number): Observable<Match>{

    return this.http.get<Match>(`${this.apiServerUrl}/matches/${matchId}`);
  }

  public addGoal(goalId : number) : Observable<Goal>{

    return this.http.post<Goal>(`${this.apiServerUrl}/teams/goal`, goalId);
  }
}
