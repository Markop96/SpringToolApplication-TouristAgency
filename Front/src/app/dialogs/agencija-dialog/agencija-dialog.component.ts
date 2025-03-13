import { Component, Inject } from '@angular/core';
import { MAT_DIALOG_DATA, MatDialogRef } from '@angular/material/dialog';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Agencija } from 'src/app/models/agencija';
import { AgencijaService } from 'src/app/services/agencija.service';

@Component({
  selector: 'app-agencija-dialog',
  templateUrl: './agencija-dialog.component.html',
  styleUrls: ['./agencija-dialog.component.css']
})
export class AgencijaDialogComponent{

  flag!: number;

  constructor(
    public snackBar: MatSnackBar,
    public dialogRef: MatDialogRef<Agencija>,
    @Inject(MAT_DIALOG_DATA) public data: Agencija,
    public service: AgencijaService
  ) { }

  public add() {
    this.service.addAgencija(this.data).subscribe(
      (data) => {
        this.snackBar.open(`Agencija sa nazivom ${data.naziv} je uspešno dodata`, "U redu", { duration: 3500 });
      },
      (error: Error) => {
        console.log(error.name + ' ' + error.message);
        this.snackBar.open(`Neuspešno dodavanje!`, "Zatvori", { duration: 3500 });
      }
    );
  }

  public update() {
    this.service.updateAgencija(this.data).subscribe(
      (data) => {
        this.snackBar.open(`Agencija ${data.naziv} je uspešno ažurirana`, "U redu", { duration: 3500 });
      },
      (error: Error) => {
        console.log(error.name + ' ' + error.message);
        this.snackBar.open(`Neuspešno ažuriranje!`, "Zatvori", { duration: 3500 });
      }
    );
  }

  public delete() {
    this.service.deleteAgencija(this.data.id).subscribe(
      () => {
        this.snackBar.open(`Agencija je uspešno obrisana`, "U redu", { duration: 3500 });
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

  public compareAgencija(a:any, b:any) {
    return a.id == b.id;
  }
}