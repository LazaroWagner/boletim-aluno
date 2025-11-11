import { Component, OnInit } from '@angular/core';
import { AvaliacaoService } from '../../services/avaliacao.service';
import { AvaliacaoResponse } from '../../models/avaliacao.model';

@Component({
  selector: 'app-avaliacao',
  templateUrl: './avaliacao.html',
  //styleUrls: ['./avaliacao.css']
})
export class Avaliacao implements OnInit {
  avaliacoes: AvaliacaoResponse[] = [];

  constructor(private avaliacaoService: AvaliacaoService) {}

  ngOnInit(): void {
    this.avaliacaoService.getAvaliacoes().subscribe({
      next: (res) => this.avaliacoes = res,
      error: (err) => console.error('Erro ao carregar avaliações', err)
    });
  }
}
