import {Component, EventEmitter, Output} from '@angular/core';

@Component({
  selector: 'app-logout-modal',
  standalone: true,
  imports: [],
  templateUrl: './logout-modal.component.html',
  styleUrl: './logout-modal.component.css'
})
export class LogoutModalComponent {
  @Output() cancel = new EventEmitter<void>();
  @Output() confirmLogout = new EventEmitter<void>();

  onCancel() {
    this.cancel.emit();
  }

  onConfirm() {
    this.confirmLogout.emit();
  }
}
