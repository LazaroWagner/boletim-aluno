import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { AlunoRequest, AlunoResponse } from '../models/aluno.model';

@Injectable({
  providedIn: 'root'
})
export class AlunoService {
  private baseUrl = 'http://localhost:8080/aluno';

  constructor(private http: HttpClient) {}

  getAlunos(): Observable<AlunoResponse[]> {
    return this.http.get<AlunoResponse[]>(`${this.baseUrl}`);
  }

  getAlunoPorId(id: number): Observable<AlunoResponse> {
    return this.http.get<AlunoResponse>(`${this.baseUrl}/${id}`);
  }

  getAlunosPorTurma(turmaId: number): Observable<AlunoResponse[]> {
    return this.http.get<AlunoResponse[]>(`${this.baseUrl}/turma/${turmaId}`);
  }

  criarAluno(dto: AlunoRequest): Observable<AlunoResponse> {
    return this.http.post<AlunoResponse>(`${this.baseUrl}`, dto);
  }

  atualizarAluno(id: number, dto: AlunoRequest): Observable<AlunoResponse> {
    return this.http.put<AlunoResponse>(`${this.baseUrl}/${id}`, dto);
  }

  deletarAluno(id: number): Observable<void> {
    return this.http.delete<void>(`${this.baseUrl}/${id}`);
  }
}