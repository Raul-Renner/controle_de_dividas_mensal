import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Devedor } from '../devedor';
import { DevedorService } from '../devedor.service';

@Component({
  selector: 'app-form-devedor',
  templateUrl: './form-devedor.component.html',
  styleUrls: ['./form-devedor.component.scss']
})
export class FormDevedorComponent implements OnInit {
  devedor: Devedor = {
    id: 0,
    nome: '',
    apelido: '',
    valor_total: 0,
    dividas: []
  };
  constructor(private devedorService: DevedorService, private router: Router) { }

  ngOnInit(): void {
  }

  createDevedor(): void {
    this.devedorService.createDevedor(this.devedor).subscribe((res: any) => {
      this.devedorService.showMessage("Devedor cadastrado com sucesso!", false);
      this.router.navigate(['/devedores']);
    }, (err: any) => {
      this.devedorService.showMessage("Erro ao cadastrar Devedor!", false);
    });
  }


}
