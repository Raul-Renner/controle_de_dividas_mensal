import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Divida } from '../divida';
import { DividaService } from '../divida.service';

@Component({
  selector: 'app-create-divida',
  templateUrl: './create-divida.component.html',
  styleUrls: ['./create-divida.component.scss']
})
export class CreateDividaComponent implements OnInit {
  id!: number;

  divida: Divida = {
    id: 0,
    valor: 0,
    descricao: '',
    idDevedor: 0,
    data: '',
  };

  constructor(private route: ActivatedRoute,
    private dividaService: DividaService,
    private router: Router) { }

  ngOnInit(): void {
     this.id = Number(this.route.snapshot.paramMap.get('id'));
  }

  cadastrarDivida(): void {
    this.dividaService.create(this.id, this.divida).subscribe((res: any) => {
      this.dividaService.showMessage("Divida cadastrada com sucesso!", false);
      this.router.navigate(['devedor-detalhes/'+`${this.id}`])

    },(err: any) => {
      this.dividaService.showMessage("Falha ao cadastrar com sucesso!", false);
    })
  }
}
