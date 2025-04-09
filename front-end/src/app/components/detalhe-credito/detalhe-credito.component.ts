import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { CreditoService } from '../../services/credito.service';
import { Credito } from '../../models/credito.model';
import { RouterModule } from '@angular/router';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';

@Component({
  standalone: true,
  selector: 'app-detalhe-credito',
  templateUrl: './detalhe-credito.component.html',
  imports: [RouterModule, CommonModule, FormsModule, HttpClientModule]
})
export class DetalheCreditoComponent implements OnInit {
  credito?: Credito;

  constructor(
    private route: ActivatedRoute,
    private creditoService: CreditoService
  ) {}

  ngOnInit() {
    const numero = this.route.snapshot.paramMap.get('numeroCredito');
    if (numero) {
      this.creditoService.buscarPorNumero(numero).subscribe((c) => {
        this.credito = c;
      });
    }
  }
}
