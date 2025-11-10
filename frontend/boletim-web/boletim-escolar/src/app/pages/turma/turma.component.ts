import { Component, OnInit } from '@angular/core';
import { TurmaService } from '../../services/turma.service';
import { TurmaResponse } from '../../models/turma.model';

@Component({
  selector: 'app-turma',
  templateUrl: './turma.component.html',
  //styleUrls: ['./turma.component.css']
})
export class TurmaComponent implements OnInit {
  turmas: TurmaResponse[] = [];

  constructor(private turmaService: TurmaService) {}

  ngOnInit(): void {
    this.turmaService.getTurmas().subscribe({
      next: (res) => this.turmas = res,
      error: (err) => console.error('Erro ao carregar turmas', err)
    });
  }
}