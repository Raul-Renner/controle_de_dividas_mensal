import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { map, Observable } from 'rxjs';
import { Divida } from './divida';

@Injectable({
  providedIn: 'root'
})
export class DividaService {
  baseUrl = 'http://localhost:8090/systemDebtors/api/v1';

  constructor(private httpClient: HttpClient, private snackBar: MatSnackBar) { }
  showMessage(message: string, isError: boolean = false) : void {
    this.snackBar.open(message, 'x',{
      duration: 3000,
      horizontalPosition: "right",
      verticalPosition: "top",
      panelClass:isError? ['msg-error'] : ['msg-success']
    });
  }


  create(id: number, divida: Divida): Observable<Divida> {
    return this.httpClient.post<Divida>(`${this.baseUrl}/${id}/addDivida`, divida).pipe(
      map(res => res),
    );;
  }
  delete(id: number): Observable<Object> {
    return this.httpClient.delete(`${this.baseUrl+'/excluir-divida'}/${id}`).pipe(
      map(res => res),
    );
  }
  update(id: number, divida: Divida): Observable<Object> {
    return this.httpClient.put(this.baseUrl+`/${id}`+'/atualizar_divida', divida).pipe(
      map(res => res),
    );
  }
  buscarPorId(id: number): Observable<Divida>{
    return this.httpClient.get<Divida>(`${this.baseUrl+'/divida'}/${id}`);
  }

}
