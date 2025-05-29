import {inject, Injectable} from '@angular/core';
import {environment} from '../../environments/environment';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Skill} from '../models/skill.model';

@Injectable({
  providedIn: 'root'
})
export class SkillService {
  private apiUrl = `${environment.apiUrl}/skill`

  http = inject(HttpClient);

  getAllSkills(): Observable<Skill[]>{
    return this.http.get<Skill[]>(`${this.apiUrl}/all`);
  }
}
