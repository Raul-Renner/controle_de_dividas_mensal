import { Divida } from './../../../divida/divida';
import { Component, Input, OnInit, ViewChild } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { ActivatedRoute, Router } from '@angular/router';
import { DividaService } from 'src/app/components/divida/divida.service';
import { DevedorService } from '../../devedor.service';
import {MatPaginator} from '@angular/material/paginator';
import {MatTableDataSource} from '@angular/material/table';
import { Devedor } from '../../devedor';
import {Location} from '@angular/common';

@Component({
  selector: 'app-card-list-divida',
  templateUrl: './card-list-divida.component.html',
  styleUrls: ['./card-list-divida.component.scss']
})
export class CardListDividaComponent implements OnInit {
  dataSource!: MatTableDataSource<Divida>;

  @Input("dividasDevedor") dividas: Divida[] = [];
  id!: number;
  devedor!: Devedor;

  displayedColumns: string[] = ['id', 'descricao', 'data','valor', 'action'];

  @ViewChild(MatPaginator, {static: true}) paginator!: MatPaginator;

  constructor(private devedorService: DevedorService, private dividaService: DividaService,
    public dialog: MatDialog, private route: ActivatedRoute, private router: Router) {}

  ngOnInit(): void {
    this.id = Number(this.route.snapshot.paramMap.get('id'));
    this.getDividas();
  }

  deleteDivida(id: number): void {
    this.dividaService.delete(id).subscribe((res: any) => {
      this.getDividas();
      this.dividaService.showMessage("Divida removida com sucesso!", false);
    }, (err: any) => {
      this.dividaService.showMessage("Erro ao remover divida!", true);
    })
  }
  
  getDividas(){
    this.devedorService.buscarPorId(this.id).subscribe(data =>{
      this.dividas = data.dividas;
      this.dataSource = new MatTableDataSource(this.dividas);
      this.dataSource.paginator = this.paginator;
    })

  }

  updateDividaTotal(devedor: Devedor): void {
    this.devedorService.update(devedor).subscribe(() =>{})
  }
}

