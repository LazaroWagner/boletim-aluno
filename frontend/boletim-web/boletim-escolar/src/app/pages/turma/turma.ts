import { ChangeDetectorRef, Component, OnInit } from '@angular/core';
import { TurmaService } from '../../services/turma.service';
import { TurmaResponse } from '../../models/turma.model';

@Component({
  selector: 'app-turma',
  templateUrl: './turma.html',
  //styleUrls: ['./turma.css']
})
export class Turma implements OnInit {
  turmas: TurmaResponse[] = [];

  constructor(
    private turmaService: TurmaService,
    private cdr: ChangeDetectorRef
  ) {}

  ngOnInit(): void {
    this.turmaService.getTurmas().subscribe({
      next: (res) => {
        this.turmas = res;
        this.cdr.detectChanges();
      },
      error: (err) => console.error('Erro ao carregar turmas', err)
    });
  }
}