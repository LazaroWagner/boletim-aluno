import { Routes } from '@angular/router';
import { MainLayoutComponent } from './layout/main-layout/main-layout.component';

export const routes: Routes = [
  {
    path: '',
    component: MainLayoutComponent,
    children: [
      {
        path: 'boletim',
        loadComponent: () =>
          import('./pages/boletim/boletim.component').then(m => m.BoletimComponent)
      },
      {
        path: 'alunos',
        loadComponent: () =>
          import('./pages/aluno/aluno.component').then(m => m.AlunoComponent)
      },
      {
        path: 'alunos/cadastrar',
        loadComponent: () =>
          import('./pages/aluno/cadastrar-aluno/cadastrar-aluno.component').then(m => m.CadastrarAlunoComponent)
      }

    ]
  }
];

