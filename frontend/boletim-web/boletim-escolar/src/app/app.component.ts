import { Component } from '@angular/core';
import { BoletimComponent } from './pages/boletim/boletim.component';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [CommonModule, BoletimComponent],
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  title = 'boletim-escolar';
}