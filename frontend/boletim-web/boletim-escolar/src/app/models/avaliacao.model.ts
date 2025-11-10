export interface AvaliacaoRequest {
  titulo: string;
  data: string; // formato ISO: '2025-11-10'
  tipo: string;
  disciplinaId: number;
}

export interface AvaliacaoResponse {
  id: number;
  titulo: string;
  data: string;
  tipo: string;
  disciplina: {
    id: number;
    nome: string;
  };
}