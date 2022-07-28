export class Team{

  teamId : number;
  name : string;
  emblem : string;
  features : string;
  power : number;
  point : number;
  gameState : any

  constructor(teamId: number, name: string, emblem: string, features: string, power: number, point: number, gameState: any) {
    this.teamId = teamId;
    this.name = name;
    this.emblem = emblem;
    this.features = features;
    this.power = power;
    this.point = point;
    this.gameState = gameState;
  }
}
