export interface AlunoRequest {
  nome: string;
  matricula: string;
  turmaId: number;
}

export interface AlunoResponse {
  id: number;
  nome: string;
  turma: {
    id: number;
    nome: string;
  };
}