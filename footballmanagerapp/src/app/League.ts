export class League{
  public leagueId ?: number;
  name ?: string;
  matches  ?: any[];
  teams ?: any[] ;


  constructor(leagueId ?: number, name?: string, matches?: any[], teams? : any[]) {
    this.leagueId = leagueId;
    this.name = name;
    this.matches = [];
    this.teams = [];

  }
}
