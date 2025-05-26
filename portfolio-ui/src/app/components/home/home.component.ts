import { Component } from '@angular/core';
import {HeroComponent} from '../pages/hero/hero.component';
import {ProjectsComponent} from '../pages/projects/projects.component';
import {SkillsComponent} from '../pages/skills/skills.component';
import {ContactComponent} from '../pages/contact/contact.component';

@Component({
  selector: 'app-home',
  standalone: true,
  imports: [
    HeroComponent,
    ProjectsComponent,
    SkillsComponent,
    ContactComponent
  ],
  templateUrl: './home.component.html',
  styleUrl: './home.component.css'
})
export class HomeComponent {

}
