import {Component, inject, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, ReactiveFormsModule, Validators} from '@angular/forms';
import {AuthService} from '../../../services/auth.service';
import {Router} from '@angular/router';

@Component({
  selector: 'app-login',
  imports: [
    ReactiveFormsModule
  ],
  templateUrl: './login.component.html',
  styleUrl: './login.component.css'
})
export class LoginComponent implements OnInit{
  successMessage = '';
  errorMessage = '';

  loginForm: FormGroup = new FormGroup({});

  formBuilder = inject(FormBuilder);
  authService = inject(AuthService);
  router = inject(Router);

  ngOnInit() {
    this.loginForm = this.formBuilder.group({
      username: ['', [Validators.required, Validators.minLength(3), Validators.maxLength(20)]],
      password: ['', [Validators.required, Validators.minLength(8)]]
    })
  }

  login(){
    if(this.loginForm.invalid){
      return;
    }

    this.authService.login(this.loginForm.value).subscribe({
      next: (response) => {
        this.loginForm.reset();
        this.successMessage = 'Login successful!'
        this.errorMessage = ''
        setTimeout(()=> {
          this.router.navigate(['/dashboard'])
        }, 1000)
    },
      error: (error) => {
        console.error(error);
        this.errorMessage = error.error.message || 'An unexpected error occurred. Please try again.';
        this.successMessage = '';
      }
    }
    );
  }
}
