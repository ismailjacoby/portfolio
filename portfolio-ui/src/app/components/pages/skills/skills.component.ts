import {Component, inject, OnInit} from '@angular/core';
import {Skill, SkillCategory} from '../../../models/skill.model';
import {SkillService} from '../../../services/skill.service';
import {TitleCasePipe} from '@angular/common';

@Component({
  selector: 'app-skills',
  standalone: true,
  imports: [
    TitleCasePipe
  ],
  templateUrl: './skills.component.html',
  styleUrl: './skills.component.css'
})
export class SkillsComponent implements OnInit{
  SkillCategory = SkillCategory;

  skillsByCategory: { [key in SkillCategory]? : Skill[] } = {};

  categories = Object.values(SkillCategory);

  skillService = inject(SkillService);

  ngOnInit() {
    this.skillService.getAllSkills().subscribe(
      skills => {
        this.categories.forEach(category => {
          this.skillsByCategory[category] = skills.filter(skill => skill.category === category);
        });
      }
    );
  }
}
