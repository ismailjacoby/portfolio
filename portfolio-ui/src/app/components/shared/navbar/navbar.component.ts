import {Component, inject} from '@angular/core';
import {RouterLink} from '@angular/router';
import {AuthService} from '../../../services/auth.service';
import {LogoutModalComponent} from '../../modals/logout-modal/logout-modal.component';

@Component({
  selector: 'app-navbar',
  standalone: true,
  imports: [
    RouterLink,
    LogoutModalComponent
  ],
  templateUrl: './navbar.component.html',
  styleUrl: './navbar.component.css'
})
export class NavbarComponent {
  authService = inject(AuthService);

  showLogoutModal = false;

  get isLoggedIn(){
    return this.authService.isLoggedIn();
  }

  openLogoutModal(){
    this.showLogoutModal = true;
  }

  closeLogoutModal(){
    this.showLogoutModal = false;
  }

  logout(){
    this.authService.logout();
    this.closeLogoutModal();
  }
}
