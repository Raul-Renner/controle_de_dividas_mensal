import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Devedor } from '../devedor';
import { DevedorService } from '../devedor.service';

@Component({
  selector: 'app-devedor-update',
  templateUrl: './devedor-update.component.html',
  styleUrls: ['./devedor-update.component.scss']
})
export class DevedorUpdateComponent implements OnInit {

  devedor!: Devedor;

   constructor(private devedorService: DevedorService,
   private router: Router,
   private route: ActivatedRoute) { }

  ngOnInit(): void {
    const id = Number(this.route.snapshot.paramMap.get('id'));
    this.devedorService.buscarPorId(id).subscribe(data => {
      this.devedor = data;
    });
  }

  alterarDevedor(): void{
    this.devedorService.update(this.devedor).subscribe((res: any) => {
      this.devedorService.showMessage("Dados devedor atualizado com sucesso!", false);
      this.router.navigate(['/devedores']);
    },
    (err: any) => {
      this.devedorService.showMessage("Erro ao atualizar dados do Devedor!", true);
    });
  }


}
