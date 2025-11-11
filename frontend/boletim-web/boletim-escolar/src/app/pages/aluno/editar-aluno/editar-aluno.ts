import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { CommonModule } from '@angular/common';
import { AlunoService } from 'app/services/aluno.service';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-editar-aluno',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './editar-aluno.html'
})
export class EditarAluno implements OnInit {
  id: number | null = null
  aluno: any = {};

  constructor(
    private route: ActivatedRoute, 
    private alunoService: AlunoService
  ) {}

  ngOnInit(): void {
    this.id = Number(this.route.snapshot.paramMap.get('id'));
    if (this.id) {
      this.alunoService.getAlunoPorId(this.id).subscribe(data => {
        this.aluno = data;
      });
    } 
  }

  salvar() {
    if (this.id) {
      this,this.alunoService.atualizarAluno(this.id, this.aluno).subscribe(() => {
        alert('Aluno atualizado com sucesso!');
      })
    }
  }
}