export class Team{

  teamId ?: number;
  name ?: string;
  emblem ?: string;
  features ?: string;
  power ?: number;
  point ?: number;
  won ?: number;
  lose ?: number;
  played ?: number;
  draw ?: number;
  leagueDto ?: any;

 constructor(teamId?: number, name?: string, emblem?: string, features?: string, power?: number, point?: number, won ?: number, lose ?: number, played? : number,
              draw ?: number, league? : any) {

    this.teamId = teamId;
    this.name = name;
    this.emblem = emblem;
    this.features = features;
    this.power = 50;
    this.point = 0;
    this.won = 0;
    this.lose = 0;
    this.played = 0;
    this.draw = 0;
    this.leagueDto = league;
  }



}
