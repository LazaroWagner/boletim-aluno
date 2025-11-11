import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { MatCardModule } from '@angular/material/card';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatSelectModule } from '@angular/material/select';
import { MatOptionModule } from '@angular/material/core';
import { MatInputModule } from '@angular/material/input';
import { MatButtonModule } from '@angular/material/button';
import { MatTableModule } from '@angular/material/table';

@Component({
  selector: 'app-boletim',
  standalone: true,
  templateUrl: './boletim.html',
  styleUrls: ['./boletim.scss'],
  imports: [
    CommonModule,
    FormsModule,
    MatCardModule,
    MatFormFieldModule,
    MatSelectModule,
    MatOptionModule,
    MatInputModule,
    MatButtonModule,
    MatTableModule,
  ],
})
export class Boletim {
  turmas = [
    { id: 1, nome: 'Turma A' },
    { id: 2, nome: 'Turma B' },
  ];

  disciplinas = [
    { id: 1, nome: 'Matemática' },
    { id: 2, nome: 'Português' },
  ];

  turmaSelecionada: number | null = null;
  disciplinaSelecionada: number | null = null;

  alunos: any[] = [];
  avaliacoes: any[] = [];

  notas: { [key: string]: number } = {};

  displayedColumns: string[] = [];

  carregarBoletim() {
    this.alunos = [
      { id: 1, nome: 'João' },
      { id: 2, nome: 'Maria' },
    ];

    this.avaliacoes = [
      { id: 1, titulo: 'Prova 1', peso: 2 },
      { id: 2, titulo: 'Prova 2', peso: 3 },
    ];

    this.displayedColumns = [
      'aluno',
      ...this.avaliacoes.map(a => 'avaliacao_' + a.id),
      'media',
    ];
  }

  getNota(aluno: any, avaliacaoId: number): number {
    const key = `${aluno.id}-${avaliacaoId}`;
    return this.notas[key] ?? 0;
  }

  setNota(aluno: any, avaliacaoId: number, valor: number) {
    const key = `${aluno.id}-${avaliacaoId}`;
    this.notas[key] = Number(valor);
  }

  calcularMedia(aluno: any): number {
    let somaPesos = 0;
    let somaNotas = 0;

    for (const avaliacao of this.avaliacoes) {
      const nota = this.getNota(aluno, avaliacao.id);
      somaNotas += nota * avaliacao.peso;
      somaPesos += avaliacao.peso;
    }

    return somaPesos > 0 ? Number((somaNotas / somaPesos).toFixed(2)) : 0;
  }

  salvarNotas() {
    const payload = this.alunos.map(aluno => ({
      alunoId: aluno.id,
      notas: this.avaliacoes.map(avaliacao => ({
        avaliacaoId: avaliacao.id,
        nota: this.getNota(aluno, avaliacao.id),
      })),
    }));

    console.log('Enviando para o backend:', payload);
    // Aqui você faria a chamada HTTP real
  }
}