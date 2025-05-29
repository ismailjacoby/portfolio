import {Component, inject, OnInit} from '@angular/core';
import {ProjectService} from '../../../services/project.service';
import {Project} from '../../../models/project.model';

@Component({
  selector: 'app-projects',
  standalone: true,
  imports: [],
  templateUrl: './projects.component.html',
  styleUrl: './projects.component.css'
})
export class ProjectsComponent implements OnInit{
  projectService = inject(ProjectService);
  projects: Project[] = [];

  ngOnInit(): void {
    this.projectService.getAllProjects().subscribe(
      (data) => {
      this.projects = data.filter(p => p.isPublic);
    });
  }


}
