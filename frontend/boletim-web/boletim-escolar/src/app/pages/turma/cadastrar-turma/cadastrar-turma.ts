import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, ReactiveFormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-cadastrar-turma',
  standalone: true,
  imports: [CommonModule, ReactiveFormsModule],
  templateUrl: './cadastrar-turma.html'
})
export class CadastrarTurma implements OnInit {
  turmaForm!: FormGroup;

  constructor(private fb: FormBuilder) {}

  ngOnInit() {
    this.turmaForm = this.fb.group({
      nome: [''],
      ano: ['']
    });
  }

  salvar() {
    console.log(this.turmaForm.value);
  }
}
