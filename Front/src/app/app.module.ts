import { MatSnackBarModule } from '@angular/material/snack-bar';
import { MatInputModule } from '@angular/material/input';
import { MatDatepickerModule } from '@angular/material/datepicker';
import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MatButtonModule } from '@angular/material/button';
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatSidenavModule } from '@angular/material/sidenav';
import { MatIconModule } from '@angular/material/icon';
import { MatListModule } from '@angular/material/list';
import { MatExpansionModule } from '@angular/material/expansion';

import { AppComponent } from './app.component';
import { AgencijaComponent } from './componenets/agencija/agencija.component';
import { HotelComponent } from './componenets/hotel/hotel.component';
import { DestinacijaComponent } from './componenets/destinacija/destinacija.component';
import { AppRoutingModule } from './app-routing.module';
import { HomeComponent } from './componenets/core/home/home.component';
import { AuthorComponent } from './componenets/core/author/author.component';
import { AboutComponent } from './componenets/core/about/about.component';
import { MatTableModule} from '@angular/material/table'
import { HttpClientModule } from '@angular/common/http';
import { AgencijaDialogComponent } from './dialogs/agencija-dialog/agencija-dialog.component';
import { MatDialogModule } from '@angular/material/dialog';
import { AranzmanDialogComponent } from './dialogs/aranzman-dialog/aranzman-dialog.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatNativeDateModule } from '@angular/material/core';
import { MatCheckboxModule } from '@angular/material/checkbox';
import { MatSelectModule } from '@angular/material/select';
import { MatPaginator, MatPaginatorModule } from '@angular/material/paginator';
import { HotelDialogComponent } from './dialogs/hotel-dialog/hotel-dialog.component';
import { DestinacijaDialogComponent } from './dialogs/destinacija-dialog/destinacija-dialog.component';
import { MatSortModule } from '@angular/material/sort';
import { AranzmanComponent } from './componenets/aranzman/aranzman.component';


@NgModule({
  declarations: [
    AppComponent,
    AgencijaComponent,
    HotelComponent,
    DestinacijaComponent,
    HomeComponent,
    AranzmanDialogComponent,
    AranzmanComponent,
    AuthorComponent,
    AboutComponent,
    AgencijaDialogComponent,
    AranzmanDialogComponent,
    HotelDialogComponent,
    DestinacijaDialogComponent
    
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    MatButtonModule,
    MatToolbarModule,
    MatSidenavModule,
    MatIconModule,
    MatListModule,
    MatExpansionModule,
    AppRoutingModule,
    MatTableModule,
    HttpClientModule,
    MatToolbarModule,
    MatDialogModule,
    FormsModule,
    ReactiveFormsModule,
    MatFormFieldModule,
    MatDatepickerModule,
    MatInputModule,
    MatNativeDateModule,
    MatCheckboxModule,
    MatSelectModule,
    MatPaginatorModule,
    MatSnackBarModule,
    MatSortModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
