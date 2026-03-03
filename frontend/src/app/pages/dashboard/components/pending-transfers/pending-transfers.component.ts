import { Component, EventEmitter, Input, Output } from '@angular/core';
import { CommonModule } from '@angular/common';
import { PendingTransfer } from '../../../../core/models/dashboard.model';

@Component({
  selector: 'app-pending-transfers',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './pending-transfers.component.html',
  styleUrl: './pending-transfers.component.css'
})
export class PendingTransfersComponent {
  @Input({ required: true }) transfers: PendingTransfer[] = [];
  @Output() statusChanged = new EventEmitter<{ id: number; status: PendingTransfer['status'] }>();
}
