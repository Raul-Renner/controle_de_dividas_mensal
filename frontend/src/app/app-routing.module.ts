import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { DevedorDetalhesComponent } from './components/devedor/devedor-detalhes/devedor-detalhes.component';
import { DevedorUpdateComponent } from './components/devedor/devedor-update/devedor-update.component';
import { CreateDividaComponent } from './components/divida/create-divida/create-divida.component';
import { DividaUpdateComponent } from './components/divida/divida-update/divida-update.component';
import { DevedoresCrudComponent } from './views/crud-devedores/devedores-crud.component';
import { HomeComponent } from './views/home/home.component';
import { ListDevedoresComponent } from './views/tabela-de-dados/list-devedores.component';

const routes: Routes = [
  {
    path: "",
    component: HomeComponent
  },
  {
    path: "devedores",
    component: ListDevedoresComponent,
  },
  {
    path: "create-devedor",
    component: DevedoresCrudComponent,
  },
  {
    path: "update-devedor/:id",
    component: DevedorUpdateComponent,
  },
  {
    path: "devedor-detalhes/:id",
    component: DevedorDetalhesComponent,
  },
  {
    path: "create-divida/:id",
    component: CreateDividaComponent,
  },
  {
    path: "update-divida/:idDevedor/:idDivida",
    component: DividaUpdateComponent,
  },


];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
