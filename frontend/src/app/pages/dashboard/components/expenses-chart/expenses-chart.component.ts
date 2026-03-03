import { Component, Input, OnChanges } from '@angular/core';
import { ChartComponent, NgApexchartsModule } from 'ng-apexcharts';
import { ApexAxisChartSeries, ApexChart, ApexDataLabels, ApexPlotOptions, ApexXAxis } from 'ng-apexcharts';
import { Expense } from '../../../../core/models/dashboard.model';

@Component({
  selector: 'app-expenses-chart',
  standalone: true,
  imports: [NgApexchartsModule],
  template: `<apx-chart [series]="series" [chart]="chart" [xaxis]="xaxis" [plotOptions]="plotOptions" [dataLabels]="dataLabels"></apx-chart>`,
})
export class ExpensesChartComponent implements OnChanges {
  @Input({ required: true }) expenses: Expense[] = [];

  series: ApexAxisChartSeries = [{ name: 'Amount', data: [] }];
  chart: ApexChart = { type: 'bar', height: 280, toolbar: { show: false } };
  plotOptions: ApexPlotOptions = { bar: { columnWidth: '45%', borderRadius: 4 } };
  xaxis: ApexXAxis = { categories: [] };
  dataLabels: ApexDataLabels = { enabled: false };

  ngOnChanges(): void {
    this.series = [{ name: 'Amount', data: this.expenses.map((e) => e.amount) }];
    this.xaxis = { categories: this.expenses.map((e) => e.category.replaceAll('_', ' ')) };
  }
}
