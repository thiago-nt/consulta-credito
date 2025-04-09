import { TestBed } from '@angular/core/testing';
import { HttpClientTestingModule, HttpTestingController } from '@angular/common/http/testing';
import { CreditoService } from './credito.service';
import { Credito } from '../models/credito.model';

describe('CreditoService', () => {
  let service: CreditoService;
  let httpMock: HttpTestingController;

  beforeEach(() => {
    TestBed.configureTestingModule({
      imports: [HttpClientTestingModule],
      providers: [CreditoService]
    });

    service = TestBed.inject(CreditoService);
    httpMock = TestBed.inject(HttpTestingController);
  });

  afterEach(() => {
    httpMock.verify();
  });

  it('deve buscar créditos por número da NFS-e', () => {
    const dummyCreditos: Credito[] = [
      {    
        numeroCredito: '123456',
        numeroNfse: '7891011',
        dataConstituicao: '2024-02-25',
        valorIssqn: 1500.75,
        tipoCredito: 'ISSQN',
        simplesNacional: 'Sim',
        aliquota: 5.0,
        valorFaturado: 30000.00,
        valorDeducao: 5000.00,
        baseCalculo: 25000.00 
      }
    ];

    service.listarPorNfse('456').subscribe(creditos => {
      expect(creditos.length).toBe(1);
      expect(creditos[0].numeroCredito).toBe('123456');
    });

    const req = httpMock.expectOne('/api/creditos/456');
    expect(req.request.method).toBe('GET');
    req.flush(dummyCreditos);
  });

  it('deve buscar crédito por número de crédito', () => {
    const dummyCredito: Credito = { 
        numeroCredito: '123456',
        numeroNfse: '7891011',
        dataConstituicao: '2024-02-25',
        valorIssqn: 1500.75,
        tipoCredito: 'ISSQN',
        simplesNacional: 'Sim',
        aliquota: 5.0,
        valorFaturado: 30000.00,
        valorDeducao: 5000.00,
        baseCalculo: 25000.00  };

    service.buscarPorNumero('123456').subscribe(credito => {
      expect(credito.numeroCredito).toBe('123456');
      expect(credito.valorIssqn).toBe(1500.75);
    });

    const req = httpMock.expectOne('/api/creditos/credito/123456');
    expect(req.request.method).toBe('GET');
    req.flush(dummyCredito);
  });
});