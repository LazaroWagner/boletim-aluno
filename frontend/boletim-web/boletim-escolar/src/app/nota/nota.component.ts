import { Component, OnInit } from '@angular/core';
import { NotaService } from '../services/nota.service';
import { NotaResponse } from '../models/nota.model';

@Component({
  selector: 'app-nota',
  templateUrl: './nota.component.html',
  //styleUrls: ['./nota.component.css']
})
export class NotaComponent implements OnInit {
  notas: NotaResponse[] = [];

  constructor(private notaService: NotaService) {}

  ngOnInit(): void {
    this.notaService.getNotas().subscribe({
      next: (res) => this.notas = res,
      error: (err) => console.error('Erro ao carregar notas', err)
    });
  }
}