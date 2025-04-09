import { Routes } from '@angular/router';
import { ListaCreditosComponent } from './components/lista-creditos/lista-creditos.component';
import { DetalheCreditoComponent } from './components/detalhe-credito/detalhe-credito.component';

export const routes: Routes = [
  { path: '', component: ListaCreditosComponent },
  { path: 'credito/:numeroCredito', component: DetalheCreditoComponent },
];
