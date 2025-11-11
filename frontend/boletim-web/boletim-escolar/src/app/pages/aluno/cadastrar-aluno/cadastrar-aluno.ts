import { Component, ChangeDetectorRef, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { MatCardModule } from '@angular/material/card';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { MatSelectModule } from '@angular/material/select';
import { MatButtonModule } from '@angular/material/button';
import { MatSnackBar, MatSnackBarModule } from '@angular/material/snack-bar';
import { AlunoService } from '../../../services/aluno.service';
import { AlunoRequest } from '../../../models/aluno.model';
import { TurmaService } from 'app/services/turma.service';
import { TurmaResponse } from 'app/models/turma.model';

@Component({
  selector: 'app-cadastrar-aluno',
  standalone: true,
  imports: [
    CommonModule,
    FormsModule,
    MatCardModule,
    MatFormFieldModule,
    MatInputModule,
    MatSelectModule,
    MatButtonModule,
    MatSnackBarModule
  ],
  templateUrl: './cadastrar-aluno.html',
  styleUrls: ['./cadastrar-aluno.scss']
})
export class CadastrarAluno implements OnInit {
  turmas!: TurmaResponse[];
  aluno: AlunoRequest = {
    nome: '',
    matricula: '',
    turmaId: 0
  };


  constructor(
    private alunoService: AlunoService,
    private turmaService: TurmaService,
    private snackBar: MatSnackBar,
    private cdr: ChangeDetectorRef
  ) {}

  ngOnInit(): void {
    this.turmaService.getTurmas().subscribe(data => {
      this.turmas = data;
    })
  }

  salvar() {
    if (!this.aluno.nome || !this.aluno.matricula || !this.aluno.turmaId) {
      this.snackBar.open('Preencha todos os campos.', 'Fechar', { duration: 3000 });
      return;
    }

    this.alunoService.criarAluno(this.aluno).subscribe({
      next: () => {
        this.snackBar.open('Aluno cadastrado com sucesso!', 'Fechar', { duration: 3000 });
        this.aluno = { nome: '', matricula: '', turmaId: 0 };
      },
      error: () => {
        this.snackBar.open('Erro ao cadastrar aluno.', 'Fechar', { duration: 3000 });
      }
    });
  }
}