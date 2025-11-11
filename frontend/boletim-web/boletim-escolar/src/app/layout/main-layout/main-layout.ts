import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';

import { Menu } from '../../shared/menu/menu';

@Component({
  selector: 'app-main-layout',
  standalone: true,
  imports: [CommonModule, RouterModule, Menu],
  templateUrl: './main-layout.html'
})
export class MainLayoutComponent {}