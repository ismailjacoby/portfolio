import { Component } from '@angular/core';
import {NgClass, TitleCasePipe} from '@angular/common';
import {SkillModalComponent} from '../../modals/skill-modal/skill-modal.component';
import {ProjectModalComponent} from '../../modals/project-modal/project-modal.component';
import {ExperienceModalComponent} from '../../modals/experience-modal/experience-modal.component';

@Component({
  selector: 'app-dashboard',
  standalone: true,
  imports: [
    NgClass,
    TitleCasePipe,
    SkillModalComponent,
    ProjectModalComponent,
    ExperienceModalComponent
  ],
  templateUrl: './dashboard.component.html',
  styleUrl: './dashboard.component.css'
})
export class DashboardComponent {
  selectedTab: 'project' | 'experience' | 'skill' = 'project';

  showSkillModal = false;
  showProjectModal = false;
  showExperienceModal = false;

  openModal() {
    if (this.selectedTab === 'skill') {
      this.showSkillModal = true;
    } else if (this.selectedTab === 'project') {
      this.showProjectModal = true;
    } else if (this.selectedTab === 'experience') {
      this.showExperienceModal = true;
    }
  }

  closeModals() {
    this.showSkillModal = false;
    this.showProjectModal = false;
    this.showExperienceModal = false;
  }
}
