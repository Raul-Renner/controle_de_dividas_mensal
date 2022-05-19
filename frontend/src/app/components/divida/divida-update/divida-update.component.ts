import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Divida } from '../divida';
import { DividaService } from '../divida.service';
import {Location} from '@angular/common';

@Component({
  selector: 'app-divida-update',
  templateUrl: './divida-update.component.html',
  styleUrls: ['./divida-update.component.scss']
})
export class DividaUpdateComponent implements OnInit {

  divida!: Divida;
  idDevedor!: number;
  constructor(private route: ActivatedRoute, private _location: Location,
     private dividaService: DividaService, private router: Router) { }
  ngOnInit(): void {
    this.idDevedor = Number(this.route.snapshot.paramMap.get('idDevedor'));
    const idDivida = Number(this.route.snapshot.paramMap.get('idDivida'));

    this.dividaService.buscarPorId(idDivida).subscribe(data => {
      this.divida = data;
    });
  }
  alterarDadosDivida(): void{
    this.dividaService.update(this.idDevedor, this.divida).subscribe((res: any) => {
      this._location.back();
      this.dividaService.showMessage("Divida atualizada com sucesso!", false);
    }, (err: any) =>{
      this.dividaService.showMessage("falhar ao tentar atualizar com sucesso!", false);

    })
  }
}


