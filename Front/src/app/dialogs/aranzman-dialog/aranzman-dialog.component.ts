import { Subscription } from 'rxjs';
import { HotelService } from 'src/app/services/hotel.service';
import { Hotel } from 'src/app/models/hotel';
import { Component, Inject, OnDestroy, OnInit } from '@angular/core';
import { MAT_DIALOG_DATA, MatDialogRef } from '@angular/material/dialog';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Aranzman } from 'src/app/models/aranzman';
import { AranzmanService } from 'src/app/services/aranzman.service';
import { AgencijaService } from 'src/app/services/agencija.service';
import { Agencija } from 'src/app/models/agencija';

@Component({
  selector: 'app-aranzman-dialog',
  templateUrl: './aranzman-dialog.component.html',
  styleUrls: ['./aranzman-dialog.component.css']
})
export class AranzmanDialogComponent implements OnInit,OnDestroy{
  
  Hoteli!: Hotel[];
  hotelSubscription!: Subscription;
  public flag!: number;

  constructor(public snackBar: MatSnackBar,
    public dialogRef: MatDialogRef<Aranzman>,
    @Inject(MAT_DIALOG_DATA) public data: Aranzman,
    public service: AranzmanService,
    public hotelService: HotelService,
    public agencijaService: AgencijaService
  ) {}

  ngOnDestroy(): void {
    this.hotelSubscription.unsubscribe();
  }

  ngOnInit(): void {
   this.hotelSubscription = this.hotelService.getAllHotels().subscribe(
      (data) => {
        this.Hoteli = data;
      }
    );
    (error:Error)=> {
      console.log(error.name + ' ' +error.message);
    }
  }

  public compareAranzman(a: any, b: any) {
    return a && b && a.id === b.id;
  }

  public add():void {
    this.service.addAranzman(this.data).subscribe(() => {
        this.snackBar.open(`Aranzman je uspešno dodat`, "U redu", { duration: 3500 });
      },
      (error: Error) => {
        console.log(error.name + ' ' + error.message);
        this.snackBar.open(`Neuspešno dodavanje!`, "Zatvori", { duration: 3500 });
      }
    );
  }

  public update():void {
    this.service.updateAranzman(this.data).subscribe(() => {
        this.snackBar.open(`Aranzman je uspešno ažuriran`, "U redu", { duration: 3500 });
      },
      (error: Error) => {
        console.log(error.name + ' ' + error.message);
        this.snackBar.open(`Neuspešno ažuriranje!`, "Zatvori", { duration: 3500 });
      }
    );
  }

  public delete():void {
    this.service.deleteAranzman(this.data.id).subscribe(
      () => {
        this.snackBar.open(`Aranzman je uspešno obrisan`, "U redu", { duration: 3500 });
      },
      (error: Error) => {
        console.log(error.name + ' ' + error.message);
        this.snackBar.open(`Neuspešno brisanje!`, "Zatvori", { duration: 3500 });
      }
    );
  }

  public cancel() {
    this.dialogRef.close();
    this.snackBar.open(`Odustali ste od izmene!`, "Zatvori", { duration: 3500 });
  }
}
