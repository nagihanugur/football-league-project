import { Injectable } from '@angular/core';
import {environment} from "../../environments/environment";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Team} from "../team";
import {Match} from "../match";
import {League} from "../League";

@Injectable({
  providedIn: 'root'
})
export class HttpService {

  private apiServerUrl = environment.apiBaseUrl;

  constructor(private http: HttpClient) { }

  public getTeams() : Observable<Team[]>{
    return this.http.get<Team[]>(`${this.apiServerUrl}/teams`);
  }

  public getTeamsByLeagueId(leagueId ?: number ) : Observable<Team[]>{

    return this.http.get<Team[]>(`${this.apiServerUrl}/teams/leagueId/${leagueId}`);

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
  public getMatchesByLeagueId(leagueId ?: number):Observable<Match[]>{
    return this.http.get<Match[]>(`${this.apiServerUrl}/matches/matchesByLeague/${leagueId}`);
  }
  public createFixture(leagueId ?: number) : Observable<Match[]>{
    return this.http.get<Match[]>(`${this.apiServerUrl}/matches/create/${leagueId}`);
  }
 public deleteAllMatches() : Observable<void>{
    return this.http.delete<void>(`${this.apiServerUrl}/matches/delete`);
 }

  public updateMatch(match : Match) :Observable<Match>{
    return this.http.put<Match>(`${this.apiServerUrl}/matches/update`,match)
  }

  public saveMatch(matchList : Match[]):Observable<Match[]>{
    return this.http.post<Match[]>(`${this.apiServerUrl}/matches/save`,matchList)
  }

  public deleteMatchByLeagueId(leagueId ?: number):Observable<void>{
    return this.http.delete<void>(`${this.apiServerUrl}/matches/deleteByLeagueId/${leagueId}`);
  }
  public getMatch(matchId : number): Observable<Match>{

    return this.http.get<Match>(`${this.apiServerUrl}/matches/${matchId}`);
  }

  public saveLeague(league : League):Observable<League>{
    return this.http.post<League>(`${this.apiServerUrl}/leagues/save`,league)
  }

  public deleteLeague(leagueId ?: number):Observable<void>{
    return this.http.delete<void>(`${this.apiServerUrl}/leagues/delete/${leagueId}`)
  }

  public getAllLeague():Observable<League[]>{
    return this.http.get<League[]>(`${this.apiServerUrl}/leagues`)
  }

  public getLeagueById(leagueId?: number ):Observable<League>{
    return this.http.get<League>(`${this.apiServerUrl}/leagues/${leagueId}`)
  }




}
