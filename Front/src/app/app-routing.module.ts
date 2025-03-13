import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AgencijaComponent } from './componenets/agencija/agencija.component';
import { AranzmanComponent } from './componenets/aranzman/aranzman.component';
import { HotelComponent } from './componenets/hotel/hotel.component';
import { DestinacijaComponent } from './componenets/destinacija/destinacija.component';
import { AboutComponent } from './componenets/core/about/about.component';
import { AuthorComponent } from './componenets/core/author/author.component';
import { HomeComponent } from './componenets/core/home/home.component';

const routes: Routes = [
  { path: 'agencija', component: AgencijaComponent },
  { path: 'aranzman', component: AranzmanComponent },
  { path: 'hotel', component: HotelComponent },
  { path: 'destinacija', component: DestinacijaComponent },
  { path: 'about', component: AboutComponent },
  { path: 'author', component: AuthorComponent },
  { path: 'home', component: HomeComponent},
  { path: '', redirectTo: '/home', pathMatch: 'full' } 
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
