import { CommonModule } from '@angular/common';
import { Component, Input } from '@angular/core';
import { Wallet } from '../../../../core/models/dashboard.model';

@Component({
  selector: 'app-wallet-overview',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './wallet-overview.component.html',
  styleUrl: './wallet-overview.component.css'
})
export class WalletOverviewComponent {
  @Input({ required: true }) wallets: Wallet[] = [];
}
