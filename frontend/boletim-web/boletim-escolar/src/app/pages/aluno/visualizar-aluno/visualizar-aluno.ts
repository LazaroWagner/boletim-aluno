import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { CommonModule } from '@angular/common';
import { AlunoService } from 'app/services/aluno.service';

@Component({
  selector: 'app-visualizar-aluno',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './visualizar-aluno.html'
})
export class VisualizarAluno implements OnInit {
  id: number | null = null;
  aluno: any = {};

  constructor(
    private route: ActivatedRoute,
    private alunoService: AlunoService
  ) {}

  ngOnInit() {
    this.id = Number(this.route.snapshot.paramMap.get('id'));
    if(this.id) {
      this.alunoService.getAlunoPorId(this.id).subscribe(data => {
        this.aluno = data;
      })
    }
  }
}