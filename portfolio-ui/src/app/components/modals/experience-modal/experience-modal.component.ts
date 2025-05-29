import {Component, EventEmitter, Output} from '@angular/core';

@Component({
  selector: 'app-experience-modal',
  standalone: true,
  imports: [],
  templateUrl: './experience-modal.component.html',
  styleUrl: './experience-modal.component.css'
})
export class ExperienceModalComponent {
  @Output() closeModal = new EventEmitter<void>();

  close() {
    this.closeModal.emit();
  }
}
