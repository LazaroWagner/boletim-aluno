import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { AvaliacaoRequest, AvaliacaoResponse } from '../models/avaliacao.model';

@Injectable({
  providedIn: 'root'
})
export class AvaliacaoService {
  private baseUrl = 'http://localhost:8080/avaliacao';

  constructor(private http: HttpClient) {}

  getAvaliacoes(): Observable<AvaliacaoResponse[]> {
    return this.http.get<AvaliacaoResponse[]>(`${this.baseUrl}`);
  }

  getAvaliacaoPorId(id: number): Observable<AvaliacaoResponse> {
    return this.http.get<AvaliacaoResponse>(`${this.baseUrl}/${id}`);
  }

  getAvaliacoesPorDisciplina(idDisciplina: number): Observable<AvaliacaoResponse[]> {
    return this.http.get<AvaliacaoResponse[]>(`${this.baseUrl}/disciplina/${idDisciplina}`);
  }

  criarAvaliacao(dto: AvaliacaoRequest): Observable<AvaliacaoResponse> {
    return this.http.post<AvaliacaoResponse>(`${this.baseUrl}`, dto);
  }

  atualizarAvaliacao(id: number, dto: AvaliacaoRequest): Observable<AvaliacaoResponse> {
    return this.http.put<AvaliacaoResponse>(`${this.baseUrl}/${id}`, dto);
  }

  deletarAvaliacao(id: number): Observable<void> {
    return this.http.delete<void>(`${this.baseUrl}/${id}`);
  }
}