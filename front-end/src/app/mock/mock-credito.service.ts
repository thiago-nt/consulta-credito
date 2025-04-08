import { InMemoryDbService } from 'angular-in-memory-web-api';
import { Injectable } from '@angular/core';

@Injectable({ providedIn: 'root' })
export class MockCreditoService implements InMemoryDbService {
  createDb() {
    const creditos = [
      {
        numeroCredito: "123456",
        numeroNfse: "7891011",
        dataConstituicao: "2024-02-25",
        valorIssqn: 1500.75,
        tipoCredito: "ISSQN",
        simplesNacional: "Sim",
        aliquota: 5.0,
        valorFaturado: 30000.00,
        valorDeducao: 5000.00,
        baseCalculo: 25000.00
      },
      {
        numeroCredito: "654321",
        numeroNfse: "7891011",
        dataConstituicao: "2024-03-01",
        valorIssqn: 950.50,
        tipoCredito: "ISSQN",
        simplesNacional: "Não",
        aliquota: 3.5,
        valorFaturado: 15000.00,
        valorDeducao: 2000.00,
        baseCalculo: 13000.00
      }
    ];

    return { creditos };
  }
}
