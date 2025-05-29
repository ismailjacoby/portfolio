import {Skill} from './skill.model';

export interface Project {
  title: string;
  description: string;
  imageUrl: string;
  demoUrl?: string;
  codeUrl?: string;
  isPublic: boolean;
  technologies: Skill[];
}
