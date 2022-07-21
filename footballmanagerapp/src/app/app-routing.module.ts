import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

const routes: Routes = [
  {
    path : '',
    loadChildren : ():Promise<any> =>
      import('./components/home/home.module').then(
        (m)=>m.HomeModule),
    //pathMatch : 'full'

  },
  {
    path : 'teams',
    loadChildren : ():Promise<any> =>
      import('./components/teams/teams.module').then(
        (m)=>m.TeamsModule),


  },
  {
    path : 'fixture',
    loadChildren : ():Promise<any> =>
      import('./components/fixture/fixture.module').then(
        (m)=>m.FixtureModule),


  },
  {
    path : 'states',
    loadChildren : () : Promise<any> =>
      import('./components/states/states.module').then(
        (m)=> m.StatesModule),
  },
  {
    path : 'saveTeam',
    loadChildren : () : Promise<any> =>
      import('./components/save-team/save-team.module').then(
        (m)=> m.SaveTeamModule),
  }

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
