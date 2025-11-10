import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { DisciplinaRequest, DisciplinaResponse } from '../models/disciplina.model';

@Injectable({
  providedIn: 'root'
})
export class DisciplinaService {
  private baseUrl = 'http://localhost:8080/disciplina';

  constructor(private http: HttpClient) {}

  getDisciplinas(): Observable<DisciplinaResponse[]> {
    return this.http.get<DisciplinaResponse[]>(`${this.baseUrl}`);
  }

  getDisciplinaPorId(id: number): Observable<DisciplinaResponse> {
    return this.http.get<DisciplinaResponse>(`${this.baseUrl}/${id}`);
  }

  criarDisciplina(dto: DisciplinaRequest): Observable<DisciplinaResponse> {
    return this.http.post<DisciplinaResponse>(`${this.baseUrl}`, dto);
  }

  atualizarDisciplina(id: number, dto: DisciplinaRequest): Observable<DisciplinaResponse> {
    return this.http.put<DisciplinaResponse>(`${this.baseUrl}/${id}`, dto);
  }

  deletarDisciplina(id: number): Observable<void> {
    return this.http.delete<void>(`${this.baseUrl}/${id}`);
  }
}