import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { TurmaRequest, TurmaResponse } from '../models/turma.model';

@Injectable({
  providedIn: 'root'
})
export class TurmaService {
  private baseUrl = 'http://localhost:8080/turma';

  constructor(private http: HttpClient) {}

  getTurmas(): Observable<TurmaResponse[]> {
    return this.http.get<TurmaResponse[]>(`${this.baseUrl}`);
  }

  getTurmaPorId(id: number): Observable<TurmaResponse> {
    return this.http.get<TurmaResponse>(`${this.baseUrl}/${id}`);
  }

  criarTurma(dto: TurmaRequest): Observable<TurmaResponse> {
    return this.http.post<TurmaResponse>(`${this.baseUrl}`, dto);
  }

  atualizarTurma(id: number, dto: TurmaRequest): Observable<TurmaResponse> {
    return this.http.put<TurmaResponse>(`${this.baseUrl}/${id}`, dto);
  }

  deletarTurma(id: number): Observable<void> {
    return this.http.delete<void>(`${this.baseUrl}/${id}`);
  }
}