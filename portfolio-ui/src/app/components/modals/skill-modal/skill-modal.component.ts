import {Component, EventEmitter, Output} from '@angular/core';

@Component({
  selector: 'app-skill-modal',
  standalone: true,
  imports: [],
  templateUrl: './skill-modal.component.html',
  styleUrl: './skill-modal.component.css'
})
export class SkillModalComponent {
  @Output() closeModal = new EventEmitter<void>();

  close() {
    this.closeModal.emit();
  }
}
