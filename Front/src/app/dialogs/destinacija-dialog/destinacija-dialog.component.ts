import { Component, OnInit, Inject } from '@angular/core';
import { MAT_DIALOG_DATA, MatDialogRef } from '@angular/material/dialog';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Destinacija } from 'src/app/models/destinacija';
import { DestinacijaService } from './../../services/destinacija.service';

@Component({
  selector: 'app-destinacija',
  templateUrl: './destinacija-dialog.component.html',
  styleUrls: ['./destinacija-dialog.component.css']
})
export class DestinacijaDialogComponent implements OnInit {

  flag!: number;

  constructor(
    public snackBar: MatSnackBar,
    public dialogRef: MatDialogRef<DestinacijaDialogComponent>,
    @Inject(MAT_DIALOG_DATA) public data: Destinacija,
    public destinacijaService: DestinacijaService
  ) {}

  ngOnInit(): void {
  }

  public add(): void {
    this.destinacijaService.addDestinacija(this.data).subscribe(
      (data) => {
        this.snackBar.open(`Destinacija ${data.mesto}, ${data.drzava} je uspešno dodata`, 'OK', { duration: 3500 });
      },
      (error: Error) => {
        console.error('Greška prilikom dodavanja destinacije:', error);
        this.snackBar.open(`Neuspešno dodavanje destinacije!`, 'Zatvori', { duration: 3500 });
      }
    );
  }

  public update():void {
    this.destinacijaService.updateDestinacija(this.data).subscribe(
      (data) => {
        this.snackBar.open(`Destinacija ${data.mesto}, ${data.drzava} je uspešno ažurirana`, 'U redu', { duration: 3500 });
      },
      (error: Error) => {
        console.error('Greška prilikom ažuriranja destinacije:', error);
        this.snackBar.open(`Neuspešno ažuriranje destinacije!`, 'Zatvori', { duration: 3500 });
      }
    );
  }

  

  public delete(): void {
    this.destinacijaService.deleteDestinacija(this.data.id).subscribe(
      () => {
        this.snackBar.open(`Destinacija je uspešno obrisana`, 'U redu', { duration: 3500 });
      },
      (error: Error) => {
        console.error('Greška prilikom brisanja destinacije:', error);
        this.snackBar.open(`Neuspešno brisanje destinacije!`, 'Zatvori', { duration: 3500 });
      }
    );
  }

  public cancel(): void {
    this.dialogRef.close();
    this.snackBar.open(`Odustali ste od izmene!`, 'Zatvori', { duration: 3500 });
  }

  public compareDestincaija(a:any, b:any) {
    return a.id == b.id;
  }
  
}
