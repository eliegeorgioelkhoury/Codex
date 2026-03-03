import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { DashboardResponse } from '../../core/models/dashboard.model';
import { DashboardService } from '../../core/services/dashboard.service';
import { SidebarComponent } from '../../layout/components/sidebar/sidebar.component';
import { ExpensesChartComponent } from './components/expenses-chart/expenses-chart.component';
import { PendingTransfersComponent } from './components/pending-transfers/pending-transfers.component';
import { TransactionsTableComponent } from './components/transactions-table/transactions-table.component';
import { WalletOverviewComponent } from './components/wallet-overview/wallet-overview.component';

@Component({
  selector: 'app-dashboard-page',
  standalone: true,
  imports: [
    CommonModule,
    SidebarComponent,
    WalletOverviewComponent,
    ExpensesChartComponent,
    PendingTransfersComponent,
    TransactionsTableComponent
  ],
  templateUrl: './dashboard-page.component.html',
  styleUrl: './dashboard-page.component.css'
})
export class DashboardPageComponent implements OnInit {
  dashboard?: DashboardResponse;

  constructor(private readonly dashboardService: DashboardService) {}

  ngOnInit(): void {
    this.loadDashboard();
  }

  onTransferStatusChange(event: { id: number; status: 'ACCEPTED' | 'REJECTED' | 'PENDING' | 'CANCELED' | 'COMPLETED' }): void {
    this.dashboardService.updateTransferStatus(event.id, event.status).subscribe(() => this.loadDashboard());
  }

  private loadDashboard(): void {
    this.dashboardService.getDashboard().subscribe((data) => (this.dashboard = data));
  }
}
