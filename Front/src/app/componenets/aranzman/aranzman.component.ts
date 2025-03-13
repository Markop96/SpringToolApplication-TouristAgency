import { Hotel } from 'src/app/models/hotel';
import { Component, Input, OnChanges, OnDestroy, OnInit, SimpleChanges, ViewChild } from '@angular/core';
import { MatTableDataSource } from '@angular/material/table';
import { MatSort } from '@angular/material/sort';
import { MatPaginator } from '@angular/material/paginator';
import { Subscription } from 'rxjs';
import { Aranzman } from 'src/app/models/aranzman';
import { AranzmanService } from 'src/app/services/aranzman.service';
import { MatDialog } from '@angular/material/dialog';
import { AranzmanDialogComponent } from 'src/app/dialogs/aranzman-dialog/aranzman-dialog.component';
import { Agencija } from 'src/app/models/agencija';

@Component({
  selector: 'app-aranzman',
  templateUrl: './aranzman.component.html',
  styleUrls: ['./aranzman.component.css']
})
export class AranzmanComponent implements OnInit, OnChanges, OnDestroy {

  displayedColumns = ['id', 'ukupna_cena', 'hotel', 'placeno', 'datum_realizacije', 'agencija', 'actions'];
  dataSource!: MatTableDataSource<Aranzman>;
  subscription!: Subscription;
  @Input() selectedAgencija!: Agencija;

  @ViewChild(MatSort, { static: false }) sort!: MatSort;
  @ViewChild(MatPaginator, { static: false }) paginator!: MatPaginator;

  constructor(private aranzmanService: AranzmanService, private dialog: MatDialog) {}

  ngOnDestroy(): void {
    if (this.subscription) {
      this.subscription.unsubscribe();
    }
  }

  ngOnChanges(changes: SimpleChanges): void {
    if (changes['selectedAgencija'] && this.selectedAgencija && this.selectedAgencija.id) {
      this.loadData();
    }
  }

  ngOnInit(): void {
    if (this.selectedAgencija && this.selectedAgencija.id) {
      this.loadData();
    }
  }

  loadData() {
    if (this.subscription) {
      this.subscription.unsubscribe();
    }
    this.subscription = this.aranzmanService.getAranzman(this.selectedAgencija.id).subscribe(
      (data) => {
        this.dataSource = new MatTableDataSource(data);
        this.dataSource.sort = this.sort;
        this.dataSource.paginator = this.paginator;
      },
      (error: Error) => {
        console.log(error.name + ' ' + error.message);
      }
    );
  }

  refreshData() {
    this.loadData();
  }

  openDialog(flag: number, id?: number, ukupna_cena?: number, hotel?: Hotel, placeno?: boolean, datum_realizacije?: Date, agencija?: Agencija) {
    const dialogRef = this.dialog.open(AranzmanDialogComponent, {
      data: { id, ukupna_cena, hotel, placeno, datum_realizacije, agencija }
    });
    dialogRef.componentInstance.flag = flag;
    if (flag === 1) {
      dialogRef.componentInstance.data.agencija = this.selectedAgencija;
    }

    dialogRef.afterClosed().subscribe(result => {
      if (result === 1) {
        this.loadData();
      }
    });
  }
}
