import { Component, OnDestroy, OnInit, ViewChild } from '@angular/core';
import { MatTableDataSource } from '@angular/material/table';
import { Subscription } from 'rxjs';
import { Agencija } from 'src/app/models/agencija';
import { AgencijaService } from './../../services/agencija.service';
import { MatDialog } from '@angular/material/dialog';
import { MatSort } from '@angular/material/sort';
import { MatPaginator } from '@angular/material/paginator';
import { AgencijaDialogComponent } from 'src/app/dialogs/agencija-dialog/agencija-dialog.component';

@Component({
  selector: 'app-agencija',
  templateUrl: './agencija.component.html',
  styleUrls: ['./agencija.component.css']
})
export class AgencijaComponent implements OnInit, OnDestroy {
  
  displayedColumns = ['id', 'naziv', 'adresa', 'kontakt', 'actions'];
  dataSource!: MatTableDataSource<Agencija>;
  subscription!: Subscription;
  selectedAgencija!: Agencija;
  
  @ViewChild(MatSort, {static: false}) sort!: MatSort;
  @ViewChild(MatPaginator, {static: false}) paginator!: MatPaginator;
  
  constructor(private agencijaService: AgencijaService, public dialog: MatDialog) {}
  
  ngOnInit(): void {
    this.loadData();
  }

  ngOnDestroy(): void {
    this.subscription.unsubscribe();
  }

  public loadData(): void {
    this.subscription = this.agencijaService.getAllAgencije().subscribe(
      data => {
        this.dataSource = new MatTableDataSource(data);
        this.dataSource.sort = this.sort;
        this.dataSource.paginator = this.paginator;
      },
      (error: Error) => {
        console.log(error.name + ' ' + error.message);
      }
    );
  }

  public openDialog(flag: number, id?: number, naziv?: string, adresa?: string, kontakt?: string): void {
    const dialogRef = this.dialog.open(AgencijaDialogComponent, { data: {id, naziv, adresa, kontakt }});
    dialogRef.componentInstance.flag = flag;
    dialogRef.afterClosed().subscribe(
      result => {
        if (result == 1) {
          this.loadData();
        }
      }
    );
  }

  public applyFilter(filter:any) {
    filter = filter.target.value;
    filter = filter.trim();
    filter = filter.toLocaleLowerCase();
    this.dataSource.filter = filter;
  }

  selectedRow(row:any){
    this.selectedAgencija = row;
  }
}

