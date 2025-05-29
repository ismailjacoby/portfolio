import {Component, EventEmitter, inject, OnInit, Output} from '@angular/core';
import {FormArray, FormBuilder, FormGroup, ReactiveFormsModule, Validators} from '@angular/forms';

@Component({
  selector: 'app-project-modal',
  standalone: true,
  imports: [
    ReactiveFormsModule
  ],
  templateUrl: './project-modal.component.html',
  styleUrl: './project-modal.component.css'
})
export class ProjectModalComponent implements OnInit {
  @Output() closeModal = new EventEmitter<void>();

  projectForm: FormGroup = new FormGroup({});
  availableSkills = [
    { id: 1, name: 'Angular' },
    { id: 2, name: 'Spring Boot' },
    { id: 3, name: 'PostgreSQL' },
    { id: 4, name: 'Tailwind' }
  ];

  formBuilder = inject(FormBuilder);

  ngOnInit() {
    this.projectForm = this.formBuilder.group({
      title: ['', [Validators.required, Validators.minLength(2), Validators.maxLength(100)]],
      description: ['', [Validators.required, Validators.maxLength(500)]],
      imageUrl: ['', [Validators.required, Validators.maxLength(255), Validators.pattern(/^https?:\/\//)]],
      demoUrl: ['', [Validators.maxLength(255), Validators.pattern(/^https?:\/\//)]],
      codeUrl: ['', [Validators.maxLength(255), Validators.pattern(/^https?:\/\//)]],
      isPublic: [false],
      technologies: this.formBuilder.array([], Validators.required)
    });
  }

  toggleTechnology(id: number, checked: boolean) {
    const technologies = this.projectForm.get('technologies') as FormArray;
    if (checked) {
      technologies.push(this.formBuilder.control(id));
    } else {
      const index = technologies.controls.findIndex(x => x.value === id);
      if (index >= 0) {
        technologies.removeAt(index);
      }
    }
  }

  onTechCheckboxChange(event: Event, techId: number) {
    const input = event.target as HTMLInputElement;
    this.toggleTechnology(techId, input.checked);
  }

  submit() {
    if (this.projectForm.valid) {
      const payload = this.projectForm.value;
      console.log('Submit project:', payload);
      this.closeModal.emit();
    } else {
      this.projectForm.markAllAsTouched();
    }
  }

  close() {
    this.closeModal.emit();
  }


  protected readonly HTMLInputElement = HTMLInputElement;
}
