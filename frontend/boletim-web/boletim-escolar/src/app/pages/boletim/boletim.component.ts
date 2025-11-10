import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-boletim',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './boletim.component.html',
  styleUrls: ['./boletim.component.scss']
})
export class BoletimComponent {}