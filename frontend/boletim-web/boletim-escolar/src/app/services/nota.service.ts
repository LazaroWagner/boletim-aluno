import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

// Interfaces opcionais para clareza
export interface Turma {
  id: number;
  nome: string;
}

export interface Disciplina {
  id: number;
  nome: string;
}

export interface Avaliacao {
  id: number;
  titulo: string;
  peso: number;
}

export interface Aluno {
  id: number;
  nome: string;
  notas?: { [avaliacaoId: number]: number };
}

export interface BoletimResponse {
  avaliacoes: Avaliacao[];
  alunos: Aluno[];
}

export interface NotaPayload {
  alunoId: number;
  avaliacaoId: number;
  valor: number;
}

@Injectable({
  providedIn: 'root'
})
export class NotaService {
  private baseUrl = 'http://localhost:8080';

  constructor(private http: HttpClient) {}

  getTurmas(): Observable<Turma[]> {
    return this.http.get<Turma[]>(`${this.baseUrl}/turma`);
  }

  getDisciplinas(): Observable<Disciplina[]> {
    return this.http.get<Disciplina[]>(`${this.baseUrl}/disciplina`);
  }

  getAvaliacoes(turmaId: number, disciplinaId: number): Observable<BoletimResponse> {
    return this.http.get<BoletimResponse>(`${this.baseUrl}/turma/${turmaId}/disciplina/${disciplinaId}/avaliacao`);
  }

  salvarNotas(payload: NotaPayload[]): Observable<any> {
    return this.http.post(`${this.baseUrl}/notas/lote`, payload);
  }
}