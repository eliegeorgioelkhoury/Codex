import { Component, Input } from '@angular/core';
import { CommonModule } from '@angular/common';
import { TransactionRecord } from '../../../../core/models/dashboard.model';

@Component({
  selector: 'app-transactions-table',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './transactions-table.component.html',
  styleUrl: './transactions-table.component.css'
})
export class TransactionsTableComponent {
  @Input({ required: true }) transactions: TransactionRecord[] = [];
}
