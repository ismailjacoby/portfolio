import { Component } from '@angular/core';
import {NgClass, TitleCasePipe} from '@angular/common';

@Component({
  selector: 'app-dashboard',
  standalone: true,
  imports: [
    NgClass,
    TitleCasePipe
  ],
  templateUrl: './dashboard.component.html',
  styleUrl: './dashboard.component.css'
})
export class DashboardComponent {
  selectedTab: 'project' | 'experience' | 'skill' = 'project';



}
