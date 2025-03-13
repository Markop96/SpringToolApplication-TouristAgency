import { DestinacijaService } from 'src/app/services/destinacija.service';
import { Destinacija } from './../../models/destinacija';
import { Component, OnInit, Inject } from '@angular/core';
import { MAT_DIALOG_DATA, MatDialogRef } from '@angular/material/dialog';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Hotel } from 'src/app/models/hotel';
import { HotelService } from './../../services/hotel.service';

@Component({
  selector: 'app-hotel',
  templateUrl: './hotel-dialog.component.html',
  styleUrls: ['./hotel-dialog.component.css']
})
export class HotelDialogComponent implements OnInit {

  flag!: number;
  Destinacije!: Destinacija[];

  constructor(
    public snackBar: MatSnackBar,
    public dialogRef: MatDialogRef<HotelDialogComponent>,
    @Inject(MAT_DIALOG_DATA) public data: Hotel,
    public hotelService: HotelService,
    public destinacijaService: DestinacijaService
  ) {}

  ngOnInit(): void {
    this.destinacijaService.getAllDestinacije().subscribe(
      (data) => {
        this.Destinacije = data;
      }
    );
    if (!this.data.brojZvezdica) {
      this.data.brojZvezdica = 1;
    }
  }

  increment() {
    if (this.data.brojZvezdica < 5) {
      this.data.brojZvezdica++;
    }
  }

  decrement() {
    if (this.data.brojZvezdica > 1) {
      this.data.brojZvezdica--;
    }
  }

  public add(): void {
    this.hotelService.addHotel(this.data).subscribe(
      (data) => {
        this.snackBar.open(`Hotel sa nazivom ${data.naziv} je uspešno dodat`, 'OK', { duration: 3500 });
      },
      (error: Error) => {
        console.log(error.name + ' ' + error.message);
        this.snackBar.open(`Neuspešno dodavanje!`, "Zatvori", { duration: 3500 });
      }
    );
  }

  public update(): void {
    this.hotelService.updateHotel(this.data).subscribe(
      (data) => {
        this.snackBar.open(`Hotel- ${data.naziv} je uspešno ažuriran`, "U redu", { duration: 3500 });
      },
      (error: Error) => {
        console.log(error.name + ' ' + error.message);
        this.snackBar.open(`Neuspešno ažuriranje!`, "Zatvori", { duration: 3500 });
      }
    );
  }

  public delete(): void {
    this.hotelService.deleteHotel(this.data.id).subscribe(
      () => {
        this.snackBar.open(`Hotel je uspešno obrisan`, "U redu", { duration: 3500 });
      },
      (error: Error) => {
        console.log(error.name + ' ' + error.message);
        this.snackBar.open(`Neuspešno brisanje!`, "Zatvori", { duration: 3500 });
      }
    );
  }

  public cancel(): void {
    this.dialogRef.close();
    this.snackBar.open(`Odustali ste od izmene!`, "Zatvori", { duration: 3500 });
  }

  public compareHotel(a:any, b:any) {
    return a.id == b.id;
  }

}
