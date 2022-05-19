import { LOCALE_ID, NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import {MatSidenavModule} from '@angular/material/sidenav';
import {MatListModule} from '@angular/material/list';
import { MatTableModule } from '@angular/material/table';
import {MatCardModule} from '@angular/material/card';
import {FormsModule} from '@angular/forms';
import {MatFormFieldModule} from '@angular/material/form-field';
import { HttpClientModule } from '@angular/common/http';
import {MatNativeDateModule} from '@angular/material/core';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {MatToolbarModule} from '@angular/material/toolbar';
import {MatIconModule} from '@angular/material/icon';
import {MatButtonModule} from '@angular/material/button';
import {MatInputModule} from '@angular/material/input';
import {MatDialogModule} from '@angular/material/dialog';
import { MatDatepickerModule } from '@angular/material/datepicker';
import { MatPaginatorModule } from '@angular/material/paginator';
import {ScrollingModule} from '@angular/cdk/scrolling';
import { MatSnackBarModule } from '@angular/material/snack-bar';

import { AppComponent } from './app.component';
import { NavComponent } from './components/template/nav/nav.component';
import { FooterComponent } from './components/template/footer/footer.component';
import { HeaderComponent } from './components/template/header/header.component';
import { HomeComponent } from './views/home/home.component';
import { DevedoresCrudComponent } from './views/crud-devedores/devedores-crud.component';
import { ListDevedoresComponent } from './views/tabela-de-dados/list-devedores.component';
import { DividaComponent } from './components/divida/divida.component';
import { DevedoresReadComponent } from './components/devedor/devedores-read/devedores-read.component';
import { FormDevedorComponent } from './components/devedor/form-devedor/form-devedor.component';
import { DevedorUpdateComponent } from './components/devedor/devedor-update/devedor-update.component';
import { DevedorDetalhesComponent } from './components/devedor/devedor-detalhes/devedor-detalhes.component';
import { CardPerfilComponent } from './components/devedor/cards/card-perfil/card-perfil.component';
import { CardListDividaComponent } from './components/devedor/cards/card-list-divida/card-list-divida.component';
import { CreateDividaComponent } from './components/divida/create-divida/create-divida.component';
import { DividaUpdateComponent } from './components/divida/divida-update/divida-update.component';

@NgModule({
  declarations: [
    AppComponent,
    NavComponent,
    FooterComponent,
    HeaderComponent,
    HomeComponent,
    DevedoresCrudComponent,
    ListDevedoresComponent,
    DividaComponent,
    DevedoresReadComponent,
    FormDevedorComponent,
    DevedorUpdateComponent,
    DevedorDetalhesComponent,
    CardPerfilComponent,
    CardListDividaComponent,
    CreateDividaComponent,
    DividaUpdateComponent,

  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    MatToolbarModule,
    BrowserAnimationsModule,
    MatIconModule,
    MatSidenavModule,
    MatListModule,
    MatTableModule,
    MatButtonModule,
    MatCardModule,
    MatFormFieldModule,
    FormsModule,
    MatInputModule,
    HttpClientModule,
    MatDatepickerModule,
    MatDialogModule,
    MatNativeDateModule,
    MatPaginatorModule,
    ScrollingModule,
    MatSnackBarModule



  ],
  providers: [MatDatepickerModule,MatNativeDateModule,
    { provide: LOCALE_ID, useValue: 'pt-BR'}],
  bootstrap: [AppComponent]
})
export class AppModule { }
