import { Component, OnInit } from '@angular/core';
import { AlunoService } from '../../services/aluno.service';
import { AlunoResponse } from '../../models/aluno.model';

@Component({
  selector: 'app-aluno',
  templateUrl: './aluno.component.html',
 // styleUrls: ['./aluno.component.css']
})
export class AlunoComponent implements OnInit {
  alunos: AlunoResponse[] = [];

  constructor(private alunoService: AlunoService) {}

  ngOnInit(): void {
    this.alunoService.getAlunos().subscribe({
      next: (res) => this.alunos = res,
      error: (err) => console.error('Erro ao carregar alunos', err)
    });
  }
}