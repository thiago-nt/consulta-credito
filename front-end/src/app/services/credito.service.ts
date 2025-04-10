import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Credito } from '../models/credito.model';
import { environment } from '../../../environments/environment';

@Injectable({ providedIn: 'root' })
export class CreditoService {
  private baseUrl = environment.apiBaseUrl;

  constructor(private http: HttpClient) {}

  listarPorNfse(numeroNfse: string): Observable<Credito[]> {
    return this.http.get<Credito[]>(`${this.baseUrl}/${numeroNfse}`);
  }

  buscarPorNumero(numeroCredito: string): Observable<Credito> {
    return this.http.get<Credito>(`${this.baseUrl}/credito/${numeroCredito}`);
  }
}