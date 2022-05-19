import { DevedorDetalhesComponent } from './../../devedor-detalhes/devedor-detalhes.component';
import { Component, Input, OnInit, ViewChild } from '@angular/core';
import { Devedor } from '../../devedor';
import { DevedorService } from '../../devedor.service';

@Component({
  selector: 'app-card-perfil',
  templateUrl: './card-perfil.component.html',
  styleUrls: ['./card-perfil.component.scss']
})
export class CardPerfilComponent implements OnInit {

    devedorAux!: Devedor;

    @Input("dadosDevedor") devedor!: Devedor;

    ngOnInit(): void {

    }


}
