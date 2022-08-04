export class League{
  public leagueId : number;
  name : string;
  matches  : any[];


  constructor(leagueId: number, name: string, matches: any[], ) {
    this.leagueId = leagueId;
    this.name = name;
    this.matches = matches;

  }
}
