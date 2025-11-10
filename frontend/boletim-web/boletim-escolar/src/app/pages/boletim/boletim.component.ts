import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { NotaService } from '../../services/nota.service';

@Component({
  selector: 'app-boletim',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './boletim.component.html',
  styleUrls: ['./boletim.component.scss']
})
export class BoletimComponent implements OnInit {
  turmas: any[] = [];
  disciplinas: any[] = [];
  turmaSelecionada: number | null = null;
  disciplinaSelecionada: number | null = null;

  avaliacoes: any[] = [];
  alunos: any[] = [];

  constructor(private notaService: NotaService) {}

  ngOnInit(): void {
    this.notaService.getTurmas().subscribe(t => this.turmas = t);
    this.notaService.getDisciplinas().subscribe(d => this.disciplinas = d);
  }

  carregarBoletim(): void {
    if (!this.turmaSelecionada || !this.disciplinaSelecionada) return;

    this.notaService.getAvaliacoes(this.turmaSelecionada, this.disciplinaSelecionada)
      .subscribe(data => {
        this.avaliacoes = data.avaliacoes;
        this.alunos = data.alunos.map((a: any) => ({ ...a, notas: {} }));
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
      //somaNotas += nota * peso;
    }

    return (somaNotas / somaPesos).toFixed(2);
  }

  salvarNotas(): void {
    const payload = this.alunos.flatMap(aluno =>
      Object.entries(aluno.notas).map(([avaliacaoId, valor]) => ({
        alunoId: aluno.id,
        avaliacaoId: Number(avaliacaoId),
        valor: Number(valor)
      }))
    );

    this.notaService.salvarNotas(payload).subscribe({
      next: () => alert('Notas salvas com sucesso!'),
      error: () => alert('Erro ao salvar notas.')
    });
  }
}