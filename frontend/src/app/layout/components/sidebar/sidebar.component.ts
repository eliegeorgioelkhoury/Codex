import { Component } from '@angular/core';

@Component({
  selector: 'app-sidebar',
  standalone: true,
  templateUrl: './sidebar.component.html',
  styleUrl: './sidebar.component.css'
})
export class SidebarComponent {
  menu = ['Dashboard', 'Overview', 'Payroll Payment', 'Mass Payment', 'Transaction History', 'Transfers'];
}
