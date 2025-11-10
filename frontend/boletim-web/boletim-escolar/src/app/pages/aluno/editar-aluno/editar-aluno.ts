import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-editar-aluno',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './editar-aluno.html'
})
export class EditarAluno {
  id: string | null;

  constructor(private route: ActivatedRoute) {
    this.id = this.route.snapshot.paramMap.get('id');
  }
}