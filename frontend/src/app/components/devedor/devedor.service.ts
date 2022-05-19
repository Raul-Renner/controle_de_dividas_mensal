import { Devedor } from './devedor';
import { Injectable } from '@angular/core';
import {HttpClient } from '@angular/common/http';
import { map, Observable } from 'rxjs';
import { MatSnackBar } from '@angular/material/snack-bar';

@Injectable({
  providedIn: 'root'
})
export class DevedorService {
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

  getDevedoresList(): Observable<Devedor[]> {
    return this.httpClient.get<Devedor[]>(this.baseUrl+'/devedores').pipe(
      map(res => res),
    );
  }

  createDevedor(devedor: Devedor): Observable<Devedor> {
    return this.httpClient.post<Devedor>(this.baseUrl+'/devedor', devedor).pipe(
      map(res => res),
    );
  }
  delete(id: number): Observable<Object>{
    return this.httpClient.delete(`${this.baseUrl+'/devedor'}/${id}`).pipe(
      map(res => res),
    );
  }

  update(devedor: Devedor): Observable<Object>{
    return this.httpClient.put(this.baseUrl+'/atualiza-devedor', devedor).pipe(
      map(res => res),
    );
  }

  buscarPorId(id: number): Observable<Devedor>{
    return this.httpClient.get<Devedor>(`${this.baseUrl+'/devedor'}/${id}`);
  }
  updateValorTotal(valor: number, devedor: Devedor): Observable<Object> {

    return this.httpClient.put<Devedor>(this.baseUrl+'/devedor/atualizar-divida-total', devedor);

  }


}
