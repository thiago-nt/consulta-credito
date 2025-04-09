import { ComponentFixture, TestBed } from '@angular/core/testing';
import { ListaCreditosComponent } from './lista-creditos.component';
import { CreditoService } from '../../services/credito.service';
import { of } from 'rxjs';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { FormsModule } from '@angular/forms';

describe('ListaCreditosComponent', () => {
  let component: ListaCreditosComponent;
  let fixture: ComponentFixture<ListaCreditosComponent>;
  let mockCreditoService: jasmine.SpyObj<CreditoService>;

  beforeEach(async () => {
    const creditoServiceSpy = jasmine.createSpyObj('CreditoService', ['listarPorNfse']);

    await TestBed.configureTestingModule({
      imports: [ListaCreditosComponent, CommonModule, RouterModule.forRoot([]), FormsModule],
      providers: [
        { provide: CreditoService, useValue: creditoServiceSpy }
      ]
    }).compileComponents();

    fixture = TestBed.createComponent(ListaCreditosComponent);
    component = fixture.componentInstance;
    mockCreditoService = TestBed.inject(CreditoService) as jasmine.SpyObj<CreditoService>;
  });

  it('deve buscar créditos quando numeroNfse for preenchido', () => {
    const mockCreditos = [{
        numeroCredito: '123',
        valorIssqn: 100,
        numeroNfse: '456',
        dataConstituicao: '2023-01-01',
        tipoCredito: 'CARTAO',
        simplesNacional: 'false',
        aliquota: 5,
        valorFaturado: 2000,
        valorDeducao: 0,
        baseCalculo: 2000
    }];
    
    component.numeroNfse = '456';
    mockCreditoService.listarPorNfse.and.returnValue(of(mockCreditos));

    component.buscar();

    expect(mockCreditoService.listarPorNfse).toHaveBeenCalledWith('456');
    expect(component.creditos).toEqual(mockCreditos);
  });

  it('não deve chamar o serviço se numeroNfse estiver vazio', () => {
    component.numeroNfse = '';
    component.buscar();
    expect(mockCreditoService.listarPorNfse).not.toHaveBeenCalled();
  });
});
