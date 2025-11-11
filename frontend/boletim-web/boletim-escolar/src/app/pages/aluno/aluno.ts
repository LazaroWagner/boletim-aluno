import { ChangeDetectorRef, Component, OnInit } from '@angular/core';
import { defer } from 'rxjs';
import { AlunoService } from '../../services/aluno.service';
import { AlunoResponse } from '../../models/aluno.model';
import { CommonModule } from '@angular/common';
import { Router, NavigationEnd } from '@angular/router';

import { filter } from 'rxjs/operators';


@Component({
  selector: 'app-aluno',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './aluno.html',
//  styleUrls: ['./aluno.css']
})
export class Aluno implements OnInit {
  alunos: AlunoResponse[] = [];
  alunos$ = defer(() => this.alunoService.getAlunos());

  constructor(
    private alunoService: AlunoService,
    private router: Router,
    private cdr: ChangeDetectorRef
  ) {}

    ngOnInit(): void {
    this.alunoService.getAlunos().subscribe({
      next: (res) => {
        this.alunos = res;
        this.cdr.detectChanges();
      },
      error: (err) => console.error('Erro ao carregar alunos', err)
    });
    
  }
}