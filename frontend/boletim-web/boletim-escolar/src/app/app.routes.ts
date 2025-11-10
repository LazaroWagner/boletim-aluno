import { Routes } from '@angular/router';
import { MainLayoutComponent } from './layout/main-layout/main-layout';

export const routes: Routes = [
  {
    path: '',
    component: MainLayoutComponent,
    children: [
      {
        path: 'boletim',
        loadComponent: () =>
          import('./pages/boletim/boletim').then(m => m.BoletimComponent)
      },
      {
        path: 'alunos',
        loadComponent: () =>
          import('./pages/aluno/aluno').then(m => m.AlunoComponent)
      },
      {
        path: 'alunos/cadastrar',
        loadComponent: () =>
          import('./pages/aluno/cadastrar-aluno/cadastrar-aluno').then(m => m.CadastrarAlunoComponent)
      },
      {
        path: 'alunos/editar/:id',
        loadComponent: () =>
          import('./pages/aluno/editar-aluno/editar-aluno').then(m => m.EditarAluno)
      },
      {
        path: 'alunos/:id',
        loadComponent: () =>
          import('./pages/aluno/visualizar-aluno/visualizar-aluno').then(m => m.VisualizarAluno)
      },
      {
        path: 'turmas',
        loadComponent: () =>
          import('./pages/turma/turma').then(m => m.Turma)
      },
      {
        path: 'turmas/cadastrar',
        loadComponent: () =>
          import('./pages/turma/cadastrar-turma/cadastrar-turma').then(m => m.CadastrarTurma)
      },
      {
        path: '**',
        loadComponent: () =>
          import('./pages/not-found/not-found').then(m => m.NotFound)
      }

    ]
  }
];

