export class Match{
  public matchId : number;
  teamFirst : any;
  teamSecond : any;
  goalFt : number;
  goalSt : number;
  matchDate : any;

  constructor(matchId: number, teamFirst: any, teamSecond: any, goalFt: number, goalSt: number, matchDate: any) {
    this.matchId = matchId;
    this.teamFirst = teamFirst;
    this.teamSecond = teamSecond;
    this.goalFt = goalFt;
    this.goalSt = goalSt;
    this.matchDate = matchDate;
  }
}
