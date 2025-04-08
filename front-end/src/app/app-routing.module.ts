import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ListaCreditosComponent } from './components/lista-creditos/lista-creditos.component';
import { DetalheCreditoComponent } from './components/detalhe-credito/detalhe-credito.component';

const routes: Routes = [
  { path: '', component: ListaCreditosComponent },
  { path: 'detalhe/:numeroCredito', component: DetalheCreditoComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {}
