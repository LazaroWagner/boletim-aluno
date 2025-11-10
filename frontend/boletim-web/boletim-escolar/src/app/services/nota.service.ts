import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Observable } from 'rxjs';
import { NotaRequest, NotaResponse, NotaLoteRequest, MediaAlunoResponse } from '../models/nota.model';

@Injectable({
  providedIn: 'root'
})
export class NotaService {
  private baseUrl = 'http://localhost:8080/notas';

  constructor(private http: HttpClient) {}

  getNotas(): Observable<NotaResponse[]> {
    return this.http.get<NotaResponse[]>(`${this.baseUrl}`);
  }

  getNotasPorAluno(id: number): Observable<NotaResponse[]> {
    return this.http.get<NotaResponse[]>(`${this.baseUrl}/aluno/${id}`);
  }

  getMediaFiltrada(turmaId: number, disciplinaId: number, tipo?: string, inicio?: string, fim?: string): Observable<MediaAlunoResponse[]> {
    let params = new HttpParams()
      .set('turmaId', turmaId)
      .set('disciplinaId', disciplinaId);
    if (tipo) params = params.set('tipo', tipo);
    if (inicio) params = params.set('inicio', inicio);
    if (fim) params = params.set('fim', fim);

    return this.http.get<MediaAlunoResponse[]>(`${this.baseUrl}/media/filtro`, { params });
  }

  getMediaTurmaDisciplina(idTurma: number, idDisciplina: number): Observable<MediaAlunoResponse[]> {
    return this.http.get<MediaAlunoResponse[]>(`${this.baseUrl}/media/turma/${idTurma}/disciplina/${idDisciplina}`);
  }

  criarNota(dto: NotaRequest): Observable<NotaResponse> {
    return this.http.post<NotaResponse>(`${this.baseUrl}`, dto);
  }

  criarNotasEmLote(dto: NotaLoteRequest[]): Observable<NotaResponse[]> {
    return this.http.post<NotaResponse[]>(`${this.baseUrl}/lote`, dto);
  }

  atualizarNota(id: number, dto: NotaRequest): Observable<NotaResponse> {
    return this.http.put<NotaResponse>(`${this.baseUrl}/${id}`, dto);
  }

  deletarNota(id: number): Observable<void> {
    return this.http.delete<void>(`${this.baseUrl}/${id}`);
  }
}