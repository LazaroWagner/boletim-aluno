import { Component, OnInit, inject } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatSelectModule } from '@angular/material/select';
import { MatInputModule } from '@angular/material/input';
import { MatTableModule } from '@angular/material/table';
import { MatButtonModule } from '@angular/material/button';

import { TurmaService } from '../../services/turma.service';
import { DisciplinaService } from '../../services/disciplina.service';
import { AvaliacaoService } from '../../services/avaliacao.service';
import { NotaService } from '../../services/nota.service';
import { AlunoService } from '../../services/aluno.service';

@Component({
  selector: 'app-boletim',
  standalone: true,
  imports: [
    CommonModule,
    FormsModule,
    MatFormFieldModule,
    MatSelectModule,
    MatInputModule,
    MatTableModule,
    MatButtonModule
  ],
  templateUrl: './boletim.component.html',
  styleUrls: ['./boletim.component.scss']
})
export class BoletimComponent implements OnInit {
  turmaService = inject(TurmaService);
  disciplinaService = inject(DisciplinaService);
  avaliacaoService = inject(AvaliacaoService);
  notaService = inject(NotaService);
  alunoService = inject(AlunoService);

  turmas: any[] = [];
  disciplinas: any[] = [];
  turmaSelecionada: number | null = null;
  disciplinaSelecionada: number | null = null;

  avaliacoes: any[] = [];
  alunos: any[] = [];

  ngOnInit(): void {
    this.turmaService.getTurmas().subscribe(t => this.turmas = t);
    this.disciplinaService.getDisciplinas().subscribe(d => this.disciplinas = d);
  }

  carregarBoletim(): void {
    if (!this.turmaSelecionada || !this.disciplinaSelecionada) return;

    this.avaliacaoService.getAvaliacoesPorDisciplina(this.disciplinaSelecionada)
      .subscribe(avaliacoes => {
        this.avaliacoes = avaliacoes;

        this.alunoService.getAlunosPorTurma(this.turmaSelecionada!)
          .subscribe(alunos => {
            this.alunos = alunos.map(aluno => ({
              ...aluno,
              notas: {}
            }));
          });
      });
  }

  getNota(aluno: any, avaliacaoId: number): number | null {
    return aluno.notas[avaliacaoId] ?? null;
  }

  setNota(aluno: any, avaliacaoId: number, valor: number): void {
    const nota = Number(valor);
    if (!isNaN(nota) && nota >= 0 && nota <= 10) {
      aluno.notas[avaliacaoId] = nota;
    }
  }

  calcularMedia(aluno: any): string {
    const notas = Object.entries(aluno.notas);
    if (notas.length === 0) return '-';

    let somaPesos = 0;
    let somaNotas = 0;

    for (const [avaliacaoIdStr, nota] of notas) {
      const avaliacaoId = Number(avaliacaoIdStr);
      const peso = this.avaliacoes.find(a => a.id === avaliacaoId)?.peso ?? 1;
      somaPesos += peso;
      somaNotas += Number(nota) * peso;
    }

    return (somaNotas / somaPesos).toFixed(2);
  }

  salvarNotas(): void {
    const payload = this.alunos.flatMap(aluno =>
      Object.entries(aluno.notas).map(([avaliacaoId, valor]) => ({
        alunoId: aluno.id,
        avaliacaoId: Number(avaliacaoId),
        valor: Number(valor),
        turmaId: this.turmaSelecionada!.toString()
      }))
    );

    this.notaService.criarNotasEmLote(payload).subscribe({
      next: () => alert('Notas salvas com sucesso!'),
      error: () => alert('Erro ao salvar notas.')
    });
  }
}