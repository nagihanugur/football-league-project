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

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
