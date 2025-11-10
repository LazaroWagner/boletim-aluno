import { Component, OnInit } from '@angular/core';
import { DisciplinaService } from '../../services/disciplina.service';
import { DisciplinaResponse } from '../../models/disciplina.model';

@Component({
  selector: 'app-disciplina',
  templateUrl: './disciplina.component.html',
  //styleUrls: ['./disciplina.component.css']
})
export class DisciplinaComponent implements OnInit {
  disciplinas: DisciplinaResponse[] = [];

  constructor(private disciplinaService: DisciplinaService) {}

  ngOnInit(): void {
    this.disciplinaService.getDisciplinas().subscribe({
      next: (res) => this.disciplinas = res,
      error: (err) => console.error('Erro ao carregar disciplinas', err)
    });
  }
}