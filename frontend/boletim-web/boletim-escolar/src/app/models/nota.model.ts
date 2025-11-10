export interface NotaRequest {
  alunoId: number;
  avaliacaoId: number;
  valor: number;
}

export interface NotaLoteRequest {
  alunoId: number;
  avaliacaoId: number;
  valor: number;
  turmaId: string;
}

export interface NotaResponse {
  id: number;
  valor: number;
  aluno: {
    id: number;
    nome: string;
  };
  avaliacao: {
    id: number;
    titulo: string;
    tipo: string;
    data: string;
  };
}

export interface MediaAlunoResponse {
  alunoId: number;
  alunoNome: string;
  media: number;
}