import { Component, Input, OnInit } from '@angular/core';
import { MatTableDataSource } from '@angular/material/table';
import { ActivatedRoute } from '@angular/router';
import { distinctUntilChanged, interval, map, mergeMap } from 'rxjs';
import { Divida } from '../../divida/divida';
import { Devedor } from '../devedor';
import { DevedorService } from '../devedor.service';
import { DevedorDetalhesService } from './devedor-detalhes.service';

@Component({
  selector: 'app-devedor-detalhes',
  templateUrl: './devedor-detalhes.component.html',
  styleUrls: ['./devedor-detalhes.component.scss']
})
export class DevedorDetalhesComponent implements OnInit {

  dividas: Divida[] = [];

  devedor!: Devedor;

  constructor(private devedorService: DevedorService,
    private route: ActivatedRoute) {
     }

  ngOnInit(): void {
    const id = Number(this.route.snapshot.paramMap.get('id'));
      this.devedorService.buscarPorId(id).subscribe(data =>{
        this.devedor = data;
        this.dividas = data.dividas;
        this.devedor.valor_total = this.devedor.dividas.map(v => v.valor).reduce((acc, value) => acc + value, 0);
        this.updateDividaTotal(this.devedor);
      })
  }

  updateDividaTotal(devedor: Devedor): void {
    this.devedorService.update(devedor).subscribe(() =>{})
  }

}
