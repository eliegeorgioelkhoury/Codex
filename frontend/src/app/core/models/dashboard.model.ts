export interface Wallet {
  name: string;
  currency: 'USD' | 'LBP';
  balance: number;
  flagEmoji: string;
}

export interface Expense {
  category: 'OUTGOING_TRANSFERS' | 'E_SERVICES' | 'QR_CODE_PAYMENT' | 'CASH_OUT' | 'OTHERS';
  amount: number;
}

export interface PendingTransfer {
  id: number;
  transferDate: string;
  transferType: 'INCOMING' | 'OUTGOING';
  counterpart: string;
  amount: number;
  status: 'PENDING' | 'ACCEPTED' | 'REJECTED' | 'CANCELED' | 'COMPLETED';
}

export interface TransactionRecord {
  id: number;
  transactionDate: string;
  sourceWallet: string;
  destination: string;
  status: 'PENDING' | 'ACCEPTED' | 'REJECTED' | 'CANCELED' | 'COMPLETED';
  amount: number;
  fees: number;
}

export interface DashboardResponse {
  totalAvailableAmount: number;
  wallets: Wallet[];
  expenses: Expense[];
  pendingTransfers: PendingTransfer[];
  transactions: TransactionRecord[];
}
