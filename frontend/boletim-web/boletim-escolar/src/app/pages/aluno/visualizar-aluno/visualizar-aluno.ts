import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-visualizar-aluno',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './visualizar-aluno.html'
})
export class VisualizarAluno {
  id: string | null;

  constructor(private route: ActivatedRoute) {
    this.id = this.route.snapshot.paramMap.get('id');
  }
}