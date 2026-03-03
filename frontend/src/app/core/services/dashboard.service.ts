import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { DashboardResponse, PendingTransfer } from '../models/dashboard.model';
import { environment } from '../../../environments/environment';

@Injectable({ providedIn: 'root' })
export class DashboardService {
  private readonly apiUrl = `${environment.apiBaseUrl}/dashboard`;

  constructor(private readonly http: HttpClient) {}

  getDashboard(): Observable<DashboardResponse> {
    return this.http.get<DashboardResponse>(this.apiUrl);
  }

  updateTransferStatus(id: number, status: PendingTransfer['status']): Observable<PendingTransfer> {
    return this.http.patch<PendingTransfer>(`${environment.apiBaseUrl}/transfers/${id}/status`, { status });
  }
}
