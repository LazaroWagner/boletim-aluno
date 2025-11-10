export interface AlunoRequest {
  nome: string;
  email: string;
  turmaId: number;
}

export interface AlunoResponse {
  id: number;
  nome: string;
  email: string;
  turma: {
    id: number;
    nome: string;
  };
}