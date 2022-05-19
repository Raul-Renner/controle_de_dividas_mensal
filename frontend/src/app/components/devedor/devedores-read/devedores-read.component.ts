import { Component, OnInit, ViewChild } from '@angular/core';
import { Router } from '@angular/router';
import { Devedor } from '../devedor';
import { DevedorService } from '../devedor.service';
import {MatPaginator} from '@angular/material/paginator';
import {MatTableDataSource} from '@angular/material/table';

@Component({
  selector: 'app-devedores-read',
  templateUrl: './devedores-read.component.html',
  styleUrls: ['./devedores-read.component.scss']
})

export class DevedoresReadComponent implements OnInit {
  dataSource!: MatTableDataSource<Devedor>;

  devedores: Devedor[] = [];

  displayedColumns: string[] = ['id', 'nome', 'apelido','valorTotal','action'];

  @ViewChild(MatPaginator, {static: true}) paginator!: MatPaginator;

  constructor(private devedorService: DevedorService, private router: Router) {

  }

  ngOnInit(): void {
    this.getDevedores();
  }

  private getDevedores(){
    this.devedorService.getDevedoresList().subscribe(devedores =>{
      this.devedores = devedores;
      this.dataSource = new MatTableDataSource(this.devedores);
      this.dataSource.paginator = this.paginator;
    });
  }
  deleteDevedor(id: number): void{
    this.devedorService.delete(id).subscribe((res: any) =>{
      this.devedorService.showMessage("Devedor removido com sucesso!", false);
      this.getDevedores();
    }, (err: any) =>{
      this.devedorService.showMessage("Falha ao remover devedor!", true);
    })
  }

}

