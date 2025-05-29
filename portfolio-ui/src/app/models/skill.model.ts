export interface Skill{
  name: string;
  category: SkillCategory;
}

export enum SkillCategory {
  FRONTEND = 'FRONTEND',
  BACKEND = 'BACKEND',
  DATABASE = 'DATABASE',
  TOOLS = 'TOOLS',
  DESIGN = 'DESIGN'
}
