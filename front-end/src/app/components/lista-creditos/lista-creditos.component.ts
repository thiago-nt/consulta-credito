import { Component } from '@angular/core';
import { CreditoService } from '../../services/credito.service';
import { Credito } from '../../models/credito.model';
import { RouterModule } from '@angular/router';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';

@Component({
  standalone: true,
  selector: 'app-lista-creditos',
  templateUrl: './lista-creditos.component.html',
  styleUrls: ['./lista-creditos.component.css'],
  imports: [RouterModule, CommonModule, FormsModule, HttpClientModule]
})
export class ListaCreditosComponent {
  numeroNfse = '';
  creditos: Credito[] = [];

  constructor(private creditoService: CreditoService) {}

  buscar() {
    if (!this.numeroNfse) return;
      this.creditoService.listarPorNfse(this.numeroNfse).subscribe((dados) => {
      this.creditos = dados;
    });
  }
}